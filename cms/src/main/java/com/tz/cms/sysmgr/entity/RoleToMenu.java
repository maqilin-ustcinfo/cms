package com.tz.cms.sysmgr.entity;

import java.io.Serializable;

/**
 * @author maqilin
 * @description: 角色菜单
 * @date 2019/2/13 10:39
 */
public class RoleToMenu implements Serializable {

    private Long roleId;

    private Long menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
