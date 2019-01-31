package com.tz.cms.sysmgr.controller;

import com.tz.cms.framework.util.UserUtils;
import com.tz.cms.sysmgr.dto.UserDto;
import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.service.IUserService;
import com.tz.cms.sysmgr.service.impl.UserService;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * @author maqilin
 * @description:用户控制层
 * @date 2019/1/30 16:00
 */
@Controller
@RequestMapping("/sysmgr/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    IUserService userService;


    @RequestMapping("/gotoUserInfo")
    public String gotoUserInfo(){
        return "sysmanage/user/userInfo";
    }

    @RequestMapping("/gotoChangePwd")
    public String gotoChangePwd(){
        return "sysmanage/user/changePwd";
    }

    /**
     * 获取个人信息
     * @return
     */
    @RequestMapping("/getUserInfoById")
    @ResponseBody
    public UserDto queryUserInfo(){
        UserDto user = userService.queryUserById(UserUtils.getCurrrentUserId());
        return user;
    }

    /**
     * 更新用户信息
     * @return
     */
    @RequestMapping("/saveSelfUserInfo")
    @ResponseBody
    public Map<String,Object> saveSelfUserInfo(@RequestBody  User user){
        Map<String,Object> resultMap = new HashMap<>();
        if(userService.updateUser(user) > 0){
            resultMap.put("result","保存成功");
        }else{
            resultMap.put("result","保存失败");
        }
        return resultMap;
    }
    
    /**
     * 更新密码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return
     */
    @RequestMapping("/saveChangePwd")
    @ResponseBody
    public Map<String,Object> saveChangePwd(String oldPassword,String newPassword,HttpSession session){
        Map<String,Object> resultMap = new HashMap<>();

        User user = (User)session.getAttribute("user");
        if(user == null){
        	resultMap.put("result","未获取登陆用户");
        	return resultMap;
        }
        if(StringUtils.isNotEmpty(oldPassword) 
        		&& StringUtils.isNotEmpty(newPassword)){
        	if(userService.updateUserPsd(user,oldPassword,newPassword)){
        		resultMap.put("result","修改密码成功");
        	}else{
        		resultMap.put("result","旧密码错误，修改密码失败");
        	}
        }else{
        	resultMap.put("result","旧密码或者新密码不能为空");
        }
        return resultMap;
    }

}
