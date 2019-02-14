package com.tz.cms.sysmgr.vo;

import com.tz.cms.sysmgr.entity.User;

import java.io.Serializable;
import java.util.Map;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/14 14:15
 */
public class UserVo implements Serializable {

    private static final long serialVersionUID = 3573926540976059111L;

    private User user;

    private Map<Long,Long> roleIds;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Long, Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Map<Long, Long> roleIds) {
        this.roleIds = roleIds;
    }
}
