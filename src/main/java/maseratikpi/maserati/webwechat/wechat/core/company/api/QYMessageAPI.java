package maseratikpi.maserati.webwechat.wechat.core.company.api;

import  maseratikpi.maserati.webwechat.wechat.core.common.util.JSONUtil;
import  maseratikpi.maserati.webwechat.wechat.core.company.api.config.QYAPIConfig;
import  maseratikpi.maserati.webwechat.wechat.core.company.api.response.GetQYSendMessageResponse;
import  maseratikpi.maserati.webwechat.wechat.core.company.message.*;
import  maseratikpi.maserati.webwechat.wechat.core.service.api.BaseAPI;
import  maseratikpi.maserati.webwechat.wechat.core.service.api.config.ApiConfig;
import  maseratikpi.maserati.webwechat.wechat.core.service.api.response.BaseResponse;

/**
 * ====================================================================
 * 上海聚攒软件开发有限公司
 * --------------------------------------------------------------------
 *
 * @author Nottyjay
 * @version 1.0.beta
 * ====================================================================
 */
public class QYMessageAPI extends QYBaseAPI {


    /**
     * 构造方法，设置apiConfig
     *
     * @param config 微信API配置对象
     */
    public QYMessageAPI(QYAPIConfig config) {
        super(config);
    }

    public GetQYSendMessageResponse send(QYBaseMsg message){
        GetQYSendMessageResponse response;
        String url = BASE_API_URL + "cgi-bin/message/send?access_token=#";
        BaseResponse r = executePost(url, message.toJsonString());
//        if(message instanceof QYTextMsg){
//            r = executePost(url, JSONUtil.toJson((QYTextMsg)message));
//        }else if(message instanceof QYImageMsg){
//            r = executePost(url, JSONUtil.toJson((QYImageMsg)message));
//        }else if(message instanceof QYVoiceMsg){
//            r = executePost(url, JSONUtil.toJson((QYVoiceMsg)message));
//        }else if(message instanceof QYVideoMsg){
//            r = executePost(url, JSONUtil.toJson((QYVideoMsg)message));
//        }else if(message instanceof QYFileMsg){
//            r = executePost(url, JSONUtil.toJson((QYFileMsg)message));
//        }else if(message instanceof QYNewsMsg){
//            r = executePost(url, JSONUtil.toJson((QYNewsMsg)message));
//        }
        String jsonResult = isSuccess(r.getErrcode())? r.getErrmsg() :r.toJsonString();
        response = JSONUtil.toBean(jsonResult, GetQYSendMessageResponse.class);
        return response;
    }
}
