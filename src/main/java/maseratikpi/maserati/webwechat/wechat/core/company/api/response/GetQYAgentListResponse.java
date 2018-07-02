package maseratikpi.maserati.webwechat.wechat.core.company.api.response;

import com.alibaba.fastjson.annotation.JSONField;

import  maseratikpi.maserati.webwechat.wechat.core.company.api.entity.QYAgent;
import  maseratikpi.maserati.webwechat.wechat.core.service.api.response.BaseResponse;

import java.util.List;

/**
 *  
 *  ====================================================================
 *  上海聚攒软件开发有限公司
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public class GetQYAgentListResponse extends BaseResponse {

    @JSONField(name = "agentlist")
    public List<QYAgent> agentList;

    public List<QYAgent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<QYAgent> agentList) {
        this.agentList = agentList;
    }
}
