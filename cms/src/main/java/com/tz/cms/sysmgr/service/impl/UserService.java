package com.tz.cms.sysmgr.service.impl;

import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.mapper.UserMapper;
import com.tz.cms.sysmgr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/30 11:37
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int delUser(Integer userId) {
        return userMapper.delUser(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserPsd(Integer userId, String psd) {

        int j = userMapper.updateUserPsd(userId,psd);

        return j;
    }

    @Override
    public User queryUserById(Integer userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public List<User> queryUserList(User user) {
        return this.userMapper.queryUserList(user);
    }
}
