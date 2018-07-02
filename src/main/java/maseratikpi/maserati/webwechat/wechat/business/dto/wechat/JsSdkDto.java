package maseratikpi.maserati.webwechat.wechat.business.dto.wechat;

/**
 * 获取微信签名数据
 * 
 * @author zhanghaifeng
 * @version 2016-08-16
 */
public class JsSdkDto {
	/** 时间戳 */
	private String timestamp;
	/** 随机数 */
	private String nonceStr;
	/** 签名 */
	private String signature;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
