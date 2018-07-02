package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import java.util.List;

import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.UpstreamMsgDistMonth;

/**
 * @author peiyu
 */
public class GetUpstreamMsgDistMonthResponse extends BaseResponse {

    private List<UpstreamMsgDistMonth> list;

    public List<UpstreamMsgDistMonth> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDistMonth> list) {
        this.list = list;
    }
}
