package com.tz.cms.sysmgr.service;

import com.github.pagehelper.PageInfo;
import com.tz.cms.framework.dto.PageParam;
import com.tz.cms.sysmgr.dto.UserDto;
import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.entity.UserToRole;
import com.tz.cms.sysmgr.vo.UserVo;

import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/30 11:35
 */
public interface IUserService {

    /**
     * 分页查询用户列表
     * @param user
     * @param pageParam
     * @return List<User>
     */
    PageInfo<UserDto> queryUserListPage(User user, PageParam pageParam);
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
    /**
     * 新增用户
     * @param userVo
     * @return
     */
    int addUser(UserVo userVo);

    /**
     * 修改用户
     * @param userVo
     * @return
     */
    boolean uptUser(UserVo userVo);

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
     * @param user
     * @param oldPsd
     * @param newPsd
     * @return
     */
    boolean updateUserPsd(User user, String oldPsd,String newPsd);

    /**
     * 通过用户id获取角色信息
     * @param userId
     * @return
     */
    List<UserToRole> queryUserRoleByUserId(Long userId);
}
