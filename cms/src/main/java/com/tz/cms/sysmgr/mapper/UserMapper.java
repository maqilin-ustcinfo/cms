package com.tz.cms.sysmgr.mapper;

import com.tz.cms.sysmgr.dto.UserDto;
import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.entity.UserToRole;

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
     * 批量新增用户角色
     * @param list
     * @return
     */
    boolean addUserRoleBatch(List<UserToRole> list);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int delUser(Integer userId);

    /**
     * 删除用户角色信息
     * @param userId
     * @return
     */
    boolean delUserRoleByUserId(Long userId);


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


    /**
     * 查询用户列表
     * @param user
     * @return List<User>
     */
    List<UserDto> queryUserDtoList(User user);

    /**
     * 通过用户id获取角色信息
     * @param userId
     * @return
     */
    List<UserToRole> queryUserRoleByUserId(Long userId);
}