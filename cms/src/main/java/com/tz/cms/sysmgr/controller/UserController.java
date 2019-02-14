package com.tz.cms.sysmgr.controller;

import com.github.pagehelper.PageInfo;
import com.tz.cms.framework.dto.PageParam;
import com.tz.cms.framework.util.PageUtils;
import com.tz.cms.framework.util.UserUtils;
import com.tz.cms.sysmgr.dto.UserDto;
import com.tz.cms.sysmgr.entity.Role;
import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.entity.UserToRole;
import com.tz.cms.sysmgr.service.IRoleService;
import com.tz.cms.sysmgr.service.IUserService;

import com.tz.cms.sysmgr.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.swing.*;

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

    @Autowired
    IRoleService roleService;


    @RequestMapping("/gotoUserInfo")
    public String gotoUserInfo(){
        return "sysmanage/user/userInfo";
    }

    @RequestMapping("/gotoChangePwd")
    public String gotoChangePwd(){
        return "sysmanage/user/changePwd";
    }

    /**
     * 进入用户列表页面
     * @return
     */
    @RequestMapping("/gotoUserList")
    public String gotoUserList(){
        return "sysmanage/user/userList";
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public Map<String,Object> getUserList(Long deptId,String userName,int pageNo,int pageSize){
        Map<String,Object> resultMap = new HashMap<>();

        User user = new User();
        if(deptId != null){
            user.setDeptId(Integer.parseInt(deptId+""));
        }
        if(userName != null){
            user.setUserName(userName);
        }
        PageParam pageParam = new PageParam();
        pageParam.setPageNo(pageNo);
        pageParam.setPageSize(pageSize);
        PageInfo<UserDto> UserDtoList = userService.queryUserListPage(user,pageParam);
        // 返回数据
        resultMap.put("userList",UserDtoList.getList());
        // 返回分页条
        String pageStr = PageUtils.pageStr(UserDtoList,"userMgr.getUserListPage");
        resultMap.put("pageStr",pageStr);
        return resultMap;
    }

    /**
     * 进入用户编辑页面
     * @param editFlag == 2 修改
     * @param userId
     * @return
     */
    @RequestMapping("/gotoUserEdit")
    public String gotoUserEdit(@ModelAttribute("editFlag") int editFlag,
                               Long userId, Model model){
        // 查询所有角色信息
        List<Role> roleList =  roleService.getAllRoleList();
        model.addAttribute("roleList",roleList);
        // 修改
        if(editFlag == 2){
            // 查询用户信息
            UserDto userDto = userService.queryUserById(Integer.parseInt(userId+""));
            model.addAttribute("userDto",userDto);
            // 获取用户所属的角色
            Map<Long,Long> roleCheckMap = new HashMap<>();
            List<UserToRole> userToRoles = userService.queryUserRoleByUserId(userId);
            for(UserToRole r : userToRoles){
                roleCheckMap.put(r.getRoleId(),r.getRoleId());
            }
            model.addAttribute("roleCheckMap",roleCheckMap);
        }

        return "sysmanage/user/userEdit";
    }

    /**
     * 删除用户信息
     * @param userVo
     * @return
     */
    @RequestMapping("/delUser")
    public @ResponseBody Map<String,Object> delUser(Long userId){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            userService.delUser(Integer.parseInt(userId+""));
            resultMap.put("result","删除用户成功");
        }catch(Exception e){
            e.printStackTrace();
            resultMap.put("result","删除用户失败"+e.getMessage());
        }
        return resultMap;
    }

    /**
     * 保存用户信息
     */
    @RequestMapping("/saveUser")
    public @ResponseBody Map<String,Object> saveUser(@RequestBody UserVo userVo){
        Map<String,Object> resultMap = new HashMap<>();
        User user = userVo.getUser();
        try {
            if(user != null && user.getUserId() != null){
                userService.uptUser(userVo);
                resultMap.put("result","修改用户信息成功");
            }
            if(user != null && user.getUserId() == null){
                userService.addUser(userVo);
                resultMap.put("result","新增用户信息成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            resultMap.put("result","保存用户信息失败"+e.getMessage());
        }
        return resultMap;
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
