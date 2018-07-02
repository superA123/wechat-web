package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import com.alibaba.fastjson.annotation.JSONField;

import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.CustomAccount;

import java.util.List;

/**
 * @author Clark
 * @version 2016-08-30
 */
public class GetCustomAccountsResponse extends BaseResponse {

    @JSONField(name = "kf_list")
    private List<CustomAccount> customAccountList;
    
    @JSONField(name = "kf_online_list")
    private List<CustomAccount> onlineCustomAccountList;

    public List<CustomAccount> getCustomAccountList() {
        return customAccountList;
    }

    public void setCustomAccountList(List<CustomAccount> customAccountList) {
        this.customAccountList = customAccountList;
    }

	public List<CustomAccount> getOnlineCustomAccountList() {
		return onlineCustomAccountList;
	}

	public void setOnlineCustomAccountList(List<CustomAccount> onlineCustomAccountList) {
		this.onlineCustomAccountList = onlineCustomAccountList;
	}
}
