package com.tz.cms.sysmgr.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tz.cms.sysmgr.dto.RoleDto;
import com.tz.cms.sysmgr.entity.*;
import com.tz.cms.sysmgr.service.impl.AreaService;
import com.tz.cms.sysmgr.service.impl.DeptService;
import com.tz.cms.sysmgr.service.impl.MenuService;
import com.tz.cms.sysmgr.service.impl.RoleService;
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

/**
 * @author maqilin
 * @description: 角色控制类
 * @date 2019/2/13 8:54
 */
@Controller
@RequestMapping("/sysmgr/role")
public class RoleController {

    private static Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @Autowired
    DeptService deptService;

    @Autowired
    AreaService areaService;

    @RequestMapping("/gotoRoleList")
    public String gotoRoleList(Model model){
        // 查询所有的角色列表
        List<Role> roleList = roleService.getAllRoleList();
        model.addAttribute("roleList",roleList);
        return "sysmanage/role/roleList";
    }

    /**
     * 进入添加角色/修改角色页面
     * @param editFlag = 1 添加，editFlag = 2 修改
     * @return
     */
    @RequestMapping("/gotoRoleEdit")
    public String gotoRoleEdit(@ModelAttribute("editFlag") int editFlag, Long roleId, Model model){

        List<Menu> menuList = menuService.getAllMenuList();
        List<Dept> deptList = deptService.getAllDeptList();
        List<Area> areaList = areaService.getAllAreaList();
        model.addAttribute("menuList",menuList);
        model.addAttribute("deptList",deptList);
        model.addAttribute("areaList",areaList);

        if(editFlag == 2 && roleId != null){
            // 修改查询角色
            Role role = roleService.selectByPrimaryKey(roleId);
            model.addAttribute("role",role);
            // 查询角色拥有的权限
            List<RoleToMenu> roleMenuList = roleService.getRoleToMenuById(roleId);
            List<RoleToDept> roleDeptList = roleService.getRoleToDeptById(roleId);
            List<RoleToArea> roleAreaList = roleService.getRoleToAreaById(roleId);
            model.addAttribute("roleMenuList",roleMenuList);
            model.addAttribute("roleDeptList",roleDeptList);
            model.addAttribute("roleAreaList",roleAreaList);
        }
        return "sysmanage/role/roleEdit";
    }

    @RequestMapping("/saveRole")
    @ResponseBody
    public Map<String,Object> saveRole(@RequestBody RoleDto roleDto){
        Map<String,Object> resultMap = new HashMap<>();
        int i = roleService.insertRoleDto(roleDto);
        if(i > 0){
            resultMap.put("result","保存角色成功");
        }else{
            resultMap.put("result","保存角色失败");
        }
        return resultMap;
    }

    @RequestMapping("/delRole")
    @ResponseBody
    public Map<String,Object> delRole(Long roleId){
        Map<String,Object> resultMap = new HashMap<>();
        int i = roleService.deleteRole(roleId);
        if(i > 0){
            resultMap.put("result","删除角色成功");
        }else{
            resultMap.put("result","删除角色失败");
        }
        return resultMap;
    }




}
