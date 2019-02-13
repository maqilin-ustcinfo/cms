package com.tz.cms.sysmgr.dto;

import com.tz.cms.sysmgr.entity.Role;
import com.tz.cms.sysmgr.entity.RoleToArea;
import com.tz.cms.sysmgr.entity.RoleToDept;
import com.tz.cms.sysmgr.entity.RoleToMenu;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author maqilin
 * @description: 角色包装类
 * @date 2019/2/13 14:10
 */
public class RoleDto implements Serializable {
    private Role role;
    private Map<Long,Long> menuIds;
    private Map<Long,Long> deptIds;
    private Map<Long,Long> areaIds;
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Map<Long, Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Map<Long, Long> menuIds) {
        this.menuIds = menuIds;
    }

    public Map<Long, Long> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Map<Long, Long> deptIds) {
        this.deptIds = deptIds;
    }

    public Map<Long, Long> getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(Map<Long, Long> areaIds) {
        this.areaIds = areaIds;
    }
}
