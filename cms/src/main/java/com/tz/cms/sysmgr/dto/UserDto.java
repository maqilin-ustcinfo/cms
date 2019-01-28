package com.tz.cms.sysmgr.dto;

import com.tz.cms.sysmgr.entity.Dept;
import com.tz.cms.sysmgr.entity.Role;
import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.entity.UserToRole;

import java.util.Set;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/27 16:04
 */
public class UserDto extends User {
    /** pm_sys_dept. */
    private Dept dept;

    /** The set of pm_sys_user_role. */
    private Set<Role> roleSets;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Set<Role> getRoleSets() {
        return roleSets;
    }

    public void setRoleSets(Set<Role> roleSets) {
        this.roleSets = roleSets;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "dept=" + dept +
                ", roleSets=" + roleSets +
                '}'+"User{" +
                "userId=" + this.getUserId() +
                ", userName='" + this.getUserName() + '\'' +
                ", remarks='" + this.getRemarks() + '\'' +
                '}';
    }
}
