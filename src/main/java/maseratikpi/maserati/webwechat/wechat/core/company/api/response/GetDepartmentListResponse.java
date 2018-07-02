package maseratikpi.maserati.webwechat.wechat.core.company.api.response;

import com.alibaba.fastjson.annotation.JSONField;

import  maseratikpi.maserati.webwechat.wechat.core.company.api.entity.QYDepartment;
import  maseratikpi.maserati.webwechat.wechat.core.service.api.response.BaseResponse;

import java.util.List;

/**
 *  
 *  ====================================================================
 *  上海聚攒软件开发有限公司
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public class GetDepartmentListResponse extends BaseResponse {

    @JSONField(name = "department")
    private List<QYDepartment> departments;

    public List<QYDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(List<QYDepartment> departments) {
        this.departments = departments;
    }
}
