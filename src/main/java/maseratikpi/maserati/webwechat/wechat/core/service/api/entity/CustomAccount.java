package maseratikpi.maserati.webwechat.wechat.core.service.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 客服帐号对象
 *
 * @author Clark
 * @version 2016-08-30
 */
public class CustomAccount extends BaseModel {

    @JSONField(name = "kf_account")
    private String accountName;

    @JSONField(name = "kf_nick")
    private String nickName;

    private String password;

    @JSONField(name = "kf_id")
    private String id;

    @JSONField(name = "kf_headimg")
    private String headImg;
    
    @JSONField(name = "status")
    private String status;

    @JSONField(name = "accepted_case")
    private String acceptedCase;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAcceptedCase() {
		return acceptedCase;
	}

	public void setAcceptedCase(String acceptedCase) {
		this.acceptedCase = acceptedCase;
	}

	@Override
	public String toString() {
		return "CustomAccount [accountName=" + accountName + ", nickName=" + nickName + ", id=" + id + ", headImg="
				+ headImg + ", status=" + status + ", acceptedCase=" + acceptedCase + "]";
	}
}
