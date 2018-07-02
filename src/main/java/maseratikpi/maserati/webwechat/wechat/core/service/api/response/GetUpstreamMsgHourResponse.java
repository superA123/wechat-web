package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import java.util.List;

import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.UpstreamMsgHour;

/**
 * @author peiyu
 */
public class GetUpstreamMsgHourResponse extends BaseResponse {

    private List<UpstreamMsgHour> list;

    public List<UpstreamMsgHour> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgHour> list) {
        this.list = list;
    }
}
