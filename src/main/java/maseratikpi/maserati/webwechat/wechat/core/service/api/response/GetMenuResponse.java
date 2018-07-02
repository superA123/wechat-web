package maseratikpi.maserati.webwechat.wechat.core.service.api.response;

import  maseratikpi.maserati.webwechat.wechat.core.service.api.entity.Menu;

/**
 * @author peiyu
 */
public class GetMenuResponse extends BaseResponse {

    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
