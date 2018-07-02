package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import java.util.List;

import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.UserShare;

/**
 * @author peiyu
 */
public class GetUserShareResponse extends BaseResponse {

    private List<UserShare> list;

    public List<UserShare> getList() {
        return list;
    }

    public void setList(List<UserShare> list) {
        this.list = list;
    }
}
