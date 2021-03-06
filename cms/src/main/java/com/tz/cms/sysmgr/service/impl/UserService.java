package com.tz.cms.sysmgr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tz.cms.framework.dto.PageParam;
import com.tz.cms.framework.util.EncryptUtil;
import com.tz.cms.framework.util.UserUtils;
import com.tz.cms.sysmgr.dto.UserDto;
import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.entity.UserToRole;
import com.tz.cms.sysmgr.mapper.UserMapper;
import com.tz.cms.sysmgr.service.IUserService;
import com.tz.cms.sysmgr.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/30 11:37
 */
@Service
public class UserService implements IUserService {

    public static final int SALT_SIZE = 8;
    public static final int HASH_ITERATIONS = 1024;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public int addUser(UserVo userVo) {
        // 新增用户
        User user = userVo.getUser();
        user.setUpdateBy(UserUtils.getCurrrentUserId()+"");
        user.setUpdateDate(new Date());
        user.setPassword(encyptPassword("123"));
        int i = userMapper.addUser(user);
        System.out.println("user==="+user.getUserId());
        // 新增用户-角色信息
        List<UserToRole> userToRoleList = new ArrayList<>();
        Map<Long,Long> roleIds = userVo.getRoleIds();
        for(Long id : roleIds.keySet()){
            UserToRole userToRole = new UserToRole();
            userToRole.setRoleId(id);
            userToRole.setUserId(Long.parseLong(user.getUserId()+""));
            userToRoleList.add(userToRole);
        }
        userMapper.addUserRoleBatch(userToRoleList);
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean uptUser(UserVo userVo) {
        boolean flag;
        // 修改用户
        User user = userVo.getUser();
        user.setUpdateBy(UserUtils.getCurrrentUserId()+"");
        user.setUpdateDate(new Date());
        userMapper.updateUser(user);
        // 修改
        userMapper.delUserRoleByUserId(Long.parseLong(user.getUserId()+""));
        // 新增用户-角色信息
        List<UserToRole> userToRoleList = new ArrayList<>();
        Map<Long,Long> roleIds = userVo.getRoleIds();
        for(Long id : roleIds.keySet()){
            UserToRole userToRole = new UserToRole();
            userToRole.setRoleId(id);
            userToRole.setUserId(Long.parseLong(user.getUserId()+""));
            userToRoleList.add(userToRole);
        }
        flag = userMapper.addUserRoleBatch(userToRoleList);
        return false;
    }

    @Override
    @Transactional
    public int delUser(Integer userId) {
        userMapper.delUserRoleByUserId(Long.parseLong(userId+""));
        return userMapper.delUser(userId);
    }

    @Override
    public int updateUser(User user) {
        user.setUpdateBy(UserUtils.getCurrrentUserId()+"");
        user.setUpdateDate(new Date());
        return userMapper.updateUser(user);
    }

    @Override
    public boolean updateUserPsd(User user, String oldPsd,String newPsd) {
    	boolean flag = false;
    	// 判断旧密码是否正确
    	if(vaildatePassword(oldPsd,user.getPassword())){
    		userMapper.updateUserPsd(user.getUserId(),encyptPassword(newPsd));
    		flag = true;
    	}
        return flag;
    }

    @Override
    public List<UserToRole> queryUserRoleByUserId(Long userId) {
        return userMapper.queryUserRoleByUserId(userId);
    }

    @Override
    public PageInfo<UserDto> queryUserListPage(User user, PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
        List<UserDto> userList = userMapper.queryUserDtoList(user);
        PageInfo<UserDto> pageInfo = new PageInfo<UserDto>(userList);
        return pageInfo;
    }

    @Override
    public UserDto queryUserById(Integer userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public List<User> queryUserList(User user) {
        return this.userMapper.queryUserList(user);
    }

    @Override
    public User loginUser(String loginName, String password) {
        // 1 根据loginName查询user
        User user = new User();
        user.setLoginName(loginName);
        List<User> userList = userMapper.queryUserList(user);
        if(userList.isEmpty()){
            return null;
        }else{
            // 2 比对密码
            if(vaildatePassword(password,userList.get(0).getPassword())){
                return userList.get(0);
            }
        }
        return null;
    }

    /**
     * 校验密码是否有效
     * @param plainPsd
     * @param encryptPsd
     * @return
     */
    public boolean vaildatePassword(String plainPsd,String encryptPsd){
        //将密文逆转,截取salt
        byte[] salt = EncryptUtil.decodeHex(encryptPsd.substring(0,SALT_SIZE*2));
        //重新平凑 盐+密码  进行sha1的加密
        byte[] hashPassword = EncryptUtil.sha1(plainPsd.getBytes(), salt, HASH_ITERATIONS);
        String newEncrypPsd = EncryptUtil.encodeHex(salt) + EncryptUtil.encodeHex(hashPassword);
        return newEncrypPsd.equals(encryptPsd);
    }

    /**
     * 对密码进行加密 SHA-1
     * @param plainPassword 明文密码
     * @return
     */
    public String encyptPassword (String plainPassword) {
        //生成一个随机数 ，所谓的salt 盐
        byte[] salt = EncryptUtil.generateSalt(SALT_SIZE);
        //盐+密码   进行sha1的加密
        byte[] hashPass = EncryptUtil.sha1(plainPassword.getBytes(), salt, HASH_ITERATIONS);
        //盐可逆加密+(盐+密码 sha1加密后)可逆加密
        return EncryptUtil.encodeHex(salt) + EncryptUtil.encodeHex(hashPass);
    }

}
