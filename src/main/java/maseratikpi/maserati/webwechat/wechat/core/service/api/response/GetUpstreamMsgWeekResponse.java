package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import java.util.List;

import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.UpstreamMsgWeek;

/**
 * @author peiyu
 */
public class GetUpstreamMsgWeekResponse extends BaseResponse {

    private List<UpstreamMsgWeek> list;

    public List<UpstreamMsgWeek> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgWeek> list) {
        this.list = list;
    }
}
