package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 获取多客服聊天记录列表
 * 
 * @author Clark
 * @version 2016-09-21
 */
public class GetRecordListResponse{
	
	@JSONField(name = "msgid")
	private int msgid;
	@JSONField(name = "number")
	private int number;
	@JSONField(name = "recordlist")
	private List<GetRecordResponse> recordList;
	
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<GetRecordResponse> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<GetRecordResponse> recordList) {
		this.recordList = recordList;
	}
}
