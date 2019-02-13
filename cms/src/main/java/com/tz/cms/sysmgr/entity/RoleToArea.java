package com.tz.cms.sysmgr.entity;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.Serializable;

/**
 * @author maqilin
 * @description:角色区域
 * @date 2019/2/13 10:41
 */
public class RoleToArea implements Serializable {

    private Long roleId;

    private Long areaId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
}
