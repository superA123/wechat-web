package maseratikpi.maserati.webwechat.wechat.business.dto;

/**
 * @author Clark
 * @version 2016-09-28
 */
public class VoucherDto {
	
	/**
	 * 主标题
	 */
	private String title;
	
	/**
	 * 消息标题
	 */
	private String msgTitle;
	
	/**
	 * 内容详情
	 */
	private String msgDesc;
	
	/**
	 * icon Class(默认为Weui成功icon)
	 */
	private String iconClass = "weui_icon_success";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgDesc() {
		return msgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
}
