package maseratikpi.maserati.webwechat.support.utils;

import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import maseratikpi.maserati.webwechat.wechat.core.service.api.config.ApiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import  maseratikpi.maserati.webwechat.jeesite.core.common.config.Global;
import  maseratikpi.maserati.webwechat.wechat.core.service.api.TemplateMsgAPI;
import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.TemplateMsg;
import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.TemplateParam;

/**
 * 共同处理类
 * 
 * @author Clark
 * @version 2014-11-12
 */
public class CommonUtils {

	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	private static ApiConfig config = new ApiConfig(Global.getConfig("wechat_service_appid"), Global.getConfig("wechat_service_secret"), true);

	/**
	 * Json实例对象
	 */
	private static Gson Gson = new GsonBuilder().create();

	/**
	 * 静态map，保存token等
	 */
	private static Map<String, String> ToKenMap = Maps.newHashMap();

	/**
	 * 静态map，保存短信验证码
	 */
	private static Map<String, String> VerificationCodeMap = Maps.newHashMap();

	/**
	 * 取得Api配置
	 * 
	 * @author Clark
	 * @version 2016年9月13日
	 * 
	 * @return
	 */
	public static ApiConfig getApiConfig() {
		return config;
	}


	/**
	 * 替换SFDC返回值特殊字符
	 *
	 * @author Clark
	 * @version 2016年10月10日
	 * 
	 * @param json
	 * @return
	 */
	public static String replaceSfdcRes(String json) {
		json = json.replace("'", "");
		json = json.replace("\\\"", "'");
		json = json.replace("\"", "");
		return json;
	}


	/**
	 * SHA-1
	 * 
	 * @return
	 */
	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * 随机字符串
	 * 
	 * @return
	 */
	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 时间
	 * 
	 * @return
	 */
	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}


	/**
	 * 发送模板消息
	 * 
	 * @author Clark
	 * 
	 */
	public static void sendTemplateMsg(String openid, String templateId, String url, String first, String keyword1, String keyword2, String keyword3, String keyword4, String keyword5, String remark) {
		TemplateMsgAPI api = new TemplateMsgAPI(CommonUtils.getApiConfig());
		TemplateMsg msg = new TemplateMsg();
		msg.setTouser(openid);
		msg.setTemplateId(templateId);
		msg.setUrl(url);
		Map<String, TemplateParam> data = new HashMap<>();
		TemplateParam param = new TemplateParam();
		param.setValue(first);
		data.put("first", param);
		param = new TemplateParam();
		param.setColor("#173177");
		param.setValue(keyword1);
		data.put("keyword1", param);
		param = new TemplateParam();
		param.setColor("#173177");
		param.setValue(keyword2);
		data.put("keyword2", param);
		param = new TemplateParam();
		param.setValue(keyword3);
		data.put("keyword3", param);
		param = new TemplateParam();
		param.setValue(keyword4);
		data.put("keyword4", param);
		param = new TemplateParam();
		// param.setColor("#173177");
		param.setValue(keyword5);
		data.put("keyword5", param);
		param = new TemplateParam();
		param.setValue(remark);
		data.put("remark", param);
		msg.setData(data);
		api.send(msg);
	}

	public static void sendTemplateMsg(String openid, String templateId, String url, String first, List<String> list, String remark) {
		TemplateMsgAPI api = new TemplateMsgAPI(CommonUtils.getApiConfig());
		TemplateMsg msg = new TemplateMsg();
		msg.setTouser(openid);
		msg.setTemplateId(templateId);
		msg.setUrl(url);
		Map<String, TemplateParam> data = new HashMap<>();
		TemplateParam param = new TemplateParam();
		param.setValue(first);
		data.put("first", param);
		for (int i = 1; i <= list.size(); i++) {
			param = new TemplateParam();
			param.setValue(list.get(i - 1));
			data.put("keyword" + i, param);
		}
		param = new TemplateParam();
		param.setValue(remark);
		data.put("remark", param);
		msg.setData(data);
		api.send(msg);
	}

	/**
	 * 生成验证码
	 *
	 * @author Clark
	 * @version 2016年10月20日
	 * 
	 * @return
	 */
	public static String getVerificationCode() {
		String min = Global.getConfig("sms_verificationCode_min");
		String max = Global.getConfig("sms_verificationCode_max");
		Random random = new Random();
		Integer num = random.nextInt(Integer.valueOf(max)) + Integer.valueOf(min);
		return num.toString();
	}
}
