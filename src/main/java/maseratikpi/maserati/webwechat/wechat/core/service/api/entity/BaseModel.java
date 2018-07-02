package maseratikpi.maserati.webwechat.wechat.core.service.api.entity;

import maseratikpi.maserati.webwechat.wechat.core.common.util.JSONUtil;

/**
 * 抽象实体类
 *
 * @author peiyu
 */
public abstract class BaseModel implements Model {
    @Override
    public String toJsonString() {
        return JSONUtil.toJson(this);
    }
}
