package maseratikpi.maserati.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import maseratikpi.maserati.webwechat.jeesite.core.common.config.Global;
import maseratikpi.maserati.webwechat.jeesite.core.common.utils.Exceptions;
import maseratikpi.maserati.webwechat.support.utils.CommonUtils;
import maseratikpi.maserati.webwechat.wechat.core.common.servlet.WeixinControllerSupport;
import maseratikpi.maserati.webwechat.wechat.core.service.api.CustomAPI;
import maseratikpi.maserati.webwechat.wechat.core.service.api.MaterialAPI;
import maseratikpi.maserati.webwechat.wechat.core.service.api.OauthAPI;
import maseratikpi.maserati.webwechat.wechat.core.service.api.config.ApiConfig;
import maseratikpi.maserati.webwechat.wechat.core.service.api.entity.CustomAccount;
import maseratikpi.maserati.webwechat.wechat.core.service.api.enums.MaterialType;
import maseratikpi.maserati.webwechat.wechat.core.service.api.enums.OauthScope;
import maseratikpi.maserati.webwechat.wechat.core.service.api.enums.ResultType;
import maseratikpi.maserati.webwechat.wechat.core.service.api.response.GetCustomAccountsResponse;
import maseratikpi.maserati.webwechat.wechat.core.service.api.response.GetMaterialListResponse;
import maseratikpi.maserati.webwechat.wechat.core.service.message.*;
import maseratikpi.maserati.webwechat.wechat.core.service.message.req.BaseEvent;
import maseratikpi.maserati.webwechat.wechat.core.service.message.req.MenuEvent;
import maseratikpi.maserati.webwechat.wechat.core.service.message.req.TextReqMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 微信服务号入口
 * 
 * @author Clark
 * @version 2016-09-30
 */
@RestController
@RequestMapping("/service")
public class WeixinController extends WeixinControllerSupport {

	private static final Logger logger = LoggerFactory.getLogger(WeixinController.class);

	private static final String Token = Global.getConfig("wechat_service_token");

	/**
	 * 客服排队中的用户集合
	 */
	private static LinkedList<String> CustomerList = Lists.newLinkedList();

	/**
	 * 图文素材key-value集合
	 */
	private static Map<String, String> MediaNewsMap = Maps.newHashMap();

	private ApiConfig config = CommonUtils.getApiConfig();
	private CustomAPI customAPI = new CustomAPI(config);

	/**
	 * 国际化资源管理器
	 */
	@Autowired
	protected MessageSource msgSource;

	@Override
	protected String getToken() {
		return Token;
	}

	/**
	 * 处理添加关注事件，有需要时子类重写
	 *
	 * @param event
	 * @return
	 */
	@Override
	protected BaseMsg handleSubscribe(BaseEvent event) {
		// if (event instanceof QrCodeEvent) {
		// QrCodeEvent qrCodeEvent = (QrCodeEvent) event;
		// if ("qrscene_100000".equals(qrCodeEvent.getEventKey())) {
		// return new TextMsg("100000:感谢您的关注!");
		// } else if ("qrscene_99999".equals(qrCodeEvent.getEventKey())) {
		// return new TextMsg("99999:感谢您的关注!");
		// }
		// }

		return new TextMsg(msgSource.getMessage("service_subscribe_greetings", null, Locale.CHINA));
	}

	/**
	 * 处理文本消息，有需要时子类重写
	 *
	 * @param msg
	 * @return
	 */
	@Override
	protected BaseMsg handleTextMsg(TextReqMsg msg) {
		String content = msg.getContent();
		if ("openid".equals(content)) {
			String openid = msg.getFromUserName();
			return new TextMsg("openid：" + openid);
		} 

		return handleDefaultMsg(msg);
	}

	/**
	 * 处理菜单点击事件，有需要时子类重写
	 *
	 * @param event
	 * @return
	 */
	@Override
	protected BaseMsg handleMenuClickEvent(MenuEvent event) {
		TextMsg msg = new TextMsg();
		String openid = event.getFromUserName();
		return handleDefaultEvent(event);
	}

	/** 获取在线客服信息 */
	private List<CustomAccount> getOnlineCustomList() {
		GetCustomAccountsResponse response = customAPI.getOnlineCustomAccountList();
		List<CustomAccount> list = null;
		if (response.getOnlineCustomAccountList() != null && response.getOnlineCustomAccountList().size() > 0) {
			list = response.getOnlineCustomAccountList();
			logger.debug("===在线客服数量===" + list.size());
		}
		return list;
	}

	/** 指派在线客服 */
	private CustomAccount assignOnlineCustom(List<CustomAccount> list) {
		CustomAccount custom = null;
		if (list != null && list.size() > 0) {
			// 定义随机类
			Random random = new Random();
			int result = random.nextInt(list.size());
			custom = list.get(result);
			logger.debug("===在线客服信息===" + custom.toString());
		}
		return custom;
	}

	/** 获取全部客服信息 */
	private List<CustomAccount> getKFList() {
		GetCustomAccountsResponse response = customAPI.getCustomAccountList();
		List<CustomAccount> kfList = null;
		if (response.getCustomAccountList() != null && response.getCustomAccountList().size() > 0) {
			kfList = response.getCustomAccountList();
		}
		return kfList;
	}

	/** 获取空闲客服信息. */
	private CustomAccount getFreeKFInfo() {
		CustomAccount custom = null;
		if (this.getOnlineCustomList() != null && this.getOnlineCustomList().size() != 0) {
			long num = this.getOnlineCustomList().stream().filter(o -> "0".equals(o.getAcceptedCase())).count();
			if (num > 0) {
				custom = this.getOnlineCustomList().stream().filter(o -> "0".equals(o.getAcceptedCase())).findFirst().get();
				logger.debug("===空闲客服信息===" + custom.toString());
			}
		}
		return custom;
	}

	/** 获取客服信息. */
	private CustomAccount getKFInfo(String accountName) {
		CustomAccount custom = null;
		if (this.getKFList() != null && this.getKFList().size() != 0) {
			custom = getKFList().stream().filter(o -> o.getAccountName().equals(accountName)).findFirst().get();
			logger.debug("===客服信息===" + custom.toString());
		}
		return custom;
	}

	/** 取得排队优先用户 */
	private String getOpenIdFromLine(String openId) {
		// 排队者优先
		if (!CustomerList.isEmpty()) {
			String firstOpenId = CustomerList.getFirst();
			CustomerList.removeFirst();
			return firstOpenId;
		}
		return openId;
	}

	/** 发送客服问候语 */
	private void sendCustomMsg(String openId, CustomAccount customAccount) {
		TextMsg msg = new TextMsg();
		String nickName = this.getKFInfo(customAccount.getAccountName()).getNickName();
		// 获取问候语
		String greetings = String.format(msgSource.getMessage("customer_greetings", null, Locale.CHINA), nickName);
		msg.setContent(greetings);
		customAPI.sendCustomMessage(openId, msg);
	}

	/**
	 * 发送身份验证绑定提醒
	 *
	 * @author Clark
	 * @version 2016年9月27日
	 * 
	 * @param fromUserName
	 * @param toUserName
	 * @param createTime
	 * @return
	 */
	private NewsMsg sendBindingMsg(String fromUserName, String toUserName, long createTime) {
		OauthAPI oauth = new OauthAPI(config);
		String url = oauth.getOauthPageUrl(Global.getConfig("webserver_url") + "/bdwechat" + Global.getAdminPath() + msgSource.getMessage("wechat.service.tm.binding.url", null, Locale.CHINA), OauthScope.SNSAPI_BASE, "bd");
		List<Article> articles = Lists.newArrayList();
		Article article = new Article();
		article.setTitle(msgSource.getMessage("wechat.service.tm.binding.title", null, Locale.CHINA));
		article.setDescription(msgSource.getMessage("wechat.service.tm.binding.description", null, Locale.CHINA));
		article.setPicUrl(Global.getConfig("webserver_url") + "/bdwechat" + msgSource.getMessage("wechat.service.tm.binding.picUrl", null, Locale.CHINA));
		article.setUrl(url);
		articles.add(article);

		NewsMsg msg = new NewsMsg();
		msg.setFromUserName(fromUserName);
		msg.setToUserName(toUserName);
		msg.setCreateTime(createTime);
		msg.setArticles(articles);

		return msg;
	}

	/**
	 * 关键字回复
	 *
	 * @author Clark
	 * @version 2017年1月12日
	 * 
	 * @param openid
	 * @param keyword
	 * @return
	 */
	private boolean keywordReply(String openid, String keyword) {
		if (MediaNewsMap.isEmpty()) {
			this.getMaterial();
		}
		keyword = keyword.toLowerCase();
		if (MediaNewsMap.containsKey(keyword)) {
			MpNewsMsg mpNewsMsg = new MpNewsMsg();
			mpNewsMsg.setMediaId(MediaNewsMap.get(keyword));
			CustomAPI customAPI = new CustomAPI(config);
			ResultType result = customAPI.sendCustomMessage(openid, mpNewsMsg);
			if (ResultType.SUCCESS.equals(result)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 取得图文素材
	 *
	 * @author Clark
	 * @version 2016年9月27日
	 * 
	 * @param event
	 * @return
	 */
	private boolean getMaterial() {
		MediaNewsMap.clear();

		MaterialAPI materialAPI = new MaterialAPI(config);
		try {
			GetMaterialListResponse response = materialAPI.batchGetMaterial(MaterialType.NEWS, 0, 20);

			for (Map<String, Object> item : response.getItems()) {
				Map<String, Object> map = JSON.parseObject(item.get("content").toString(), Map.class);
				String newsItem = map.get("news_item").toString().replaceAll("\"", "'");
				List<Map<String, Object>> list = JSON.parseObject(newsItem, new TypeReference<List<Map<String, Object>>>() {
				});

				if (!list.isEmpty()) {
					logger.info("media_id : " + item.get("media_id"));
					logger.info("title : " + list.get(0).get("title"));
					MediaNewsMap.put(list.get(0).get("title").toString().toLowerCase(), item.get("media_id").toString());
				}
			}

			return true;
		} catch (Exception e) {
			logger.error("==========获取素材列表失败==========");
			logger.error("=" + Exceptions.getStackTraceAsString(e));
		}

		return false;
	}

}