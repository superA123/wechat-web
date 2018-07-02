package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 获取多客服聊天记录
 * 
 * @author Clark
 * @version 2016-09-21
 */
public class GetRecordResponse extends BaseResponse {

    @JSONField(name = "worker")
    private String worker;
	@JSONField(name = "openid")
    private String openid;
    @JSONField(name = "opercode")
    private String opercode;
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "time")
    private String time;
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOpercode() {
		return opercode;
	}
	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
