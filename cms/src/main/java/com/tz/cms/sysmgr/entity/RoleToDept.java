package com.tz.cms.sysmgr.entity;

/**
 * @author maqilin
 * @description: 角色部门
 * @date 2019/2/13 10:40
 */
public class RoleToDept {

    private Long roleId;

    private Long deptId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
