package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import java.util.List;

import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.InterfaceSummary;

/**
 * @author peiyu
 */
public class GetInterfaceSummaryResponse extends BaseResponse {

    private List<InterfaceSummary> list;

    public List<InterfaceSummary> getList() {
        return list;
    }

    public void setList(List<InterfaceSummary> list) {
        this.list = list;
    }
}
