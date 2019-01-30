package com.tz.cms.sysmgr.controller;

import com.tz.cms.sysmgr.dto.UserDto;
import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.service.impl.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    UserService userService;


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
        UserDto user = userService.queryUserById(1);
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
        if(userService.updateUser(user)>0){
            resultMap.put("result","保存成功");
        }else{
            resultMap.put("result","保存失败");
        }
        return resultMap;
    }

}
