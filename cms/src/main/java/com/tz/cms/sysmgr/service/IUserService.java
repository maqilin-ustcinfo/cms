package com.tz.cms.sysmgr.service;

import com.tz.cms.sysmgr.dto.UserDto;
import com.tz.cms.sysmgr.entity.User;

import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/30 11:35
 */
public interface IUserService {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int delUser(Integer userId);

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 修改密码
     * @param userId
     * @param psd
     * @return
     */
    boolean updateUserPsd(User user, String oldPsd,String newPsd);

    /**
     * 通过用户ID查询用户
     * @param userId
     * @return
     */
    UserDto queryUserById(Integer userId);

    /**
     * 查询用户列表
     * @param user
     * @return List<User>
     */
    List<User> queryUserList(User user);

    /**
     * 登陆
     * @param loginName
     * @param password
     * @return
     */
    User loginUser(String loginName,String password);
}
