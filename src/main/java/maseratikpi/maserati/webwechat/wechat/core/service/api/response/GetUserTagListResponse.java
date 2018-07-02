package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.UserTags;

/**
 * 用户标签列表
 * 
 * @author Clark
 * @version 2016-11-29
 */
public class GetUserTagListResponse extends BaseResponse {
	@JSONField(name = "tags")
	private List<UserTags> tagList;

	public List<UserTags> getTagList() {
		return tagList;
	}

	public void setTagList(List<UserTags> tagList) {
		this.tagList = tagList;
	}
}
