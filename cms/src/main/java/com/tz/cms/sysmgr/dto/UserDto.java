package com.tz.cms.sysmgr.dto;

import com.tz.cms.sysmgr.entity.User;

/**
 * @author maqilin
 * @description: 用户包装类
 * @date 2019/1/30 16:55
 */
public class UserDto extends User {

    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
