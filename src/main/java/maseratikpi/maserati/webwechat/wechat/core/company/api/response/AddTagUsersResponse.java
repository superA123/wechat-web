package maseratikpi.maserati.webwechat.wechat.core.company.api.response;

import java.util.List;

import  maseratikpi.maserati.webwechat.wechat.core.service.api.response.BaseResponse;

/**
 *  Response -- 增加标签成员
 *  ====================================================================
 *  上海聚攒软件开发有限公司
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  @since 1.3.6
 *  ====================================================================
 */
public class AddTagUsersResponse extends BaseResponse {

    private String invalidlist;
    private List<Integer> invalidparty;

    public String getInvalidlist() {
        return invalidlist;
    }

    public void setInvalidlist(String invalidlist) {
        this.invalidlist = invalidlist;
    }

    public List<Integer> getInvalidparty() {
        return invalidparty;
    }

    public void setInvalidparty(List<Integer> invalidparty) {
        this.invalidparty = invalidparty;
    }
}
