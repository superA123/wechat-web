package maseratikpi.maserati.webwechat.wechat.core.company.api.handle;

import java.util.Observable;

import  maseratikpi.maserati.webwechat.wechat.core.common.util.BeanUtil;
import  maseratikpi.maserati.webwechat.wechat.core.company.api.config.QYConfigChangeNotice;
import  maseratikpi.maserati.webwechat.wechat.core.service.handle.ApiConfigChangeHandle;

/**
 *  
 *  ====================================================================
 *  上海聚攒软件开发有限公司
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public abstract class AbstractQYApiConfigChangeHandle implements ApiConfigChangeHandle{

    public void update(Observable o, Object arg){
        if(BeanUtil.nonNull(arg) && arg instanceof QYConfigChangeNotice){
            configChange((QYConfigChangeNotice) arg);
        }
    }

    /**
     * 子类实现，当配置变化时触发该方法
     * @param notice 消息
     */
    public abstract void configChange(QYConfigChangeNotice notice);
}
