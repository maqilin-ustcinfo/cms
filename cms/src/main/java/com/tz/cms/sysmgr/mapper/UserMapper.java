package com.tz.cms.sysmgr.mapper;

import com.tz.cms.sysmgr.dto.UserDto;
import com.tz.cms.sysmgr.entity.User;

import java.util.List;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
public interface UserMapper {

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
    int updateUserPsd(Integer userId,String psd);

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


}