package com.tz.cms.sysmgr.service.impl;

import com.tz.cms.framework.util.UserUtils;
import com.tz.cms.sysmgr.dto.RoleDto;
import com.tz.cms.sysmgr.entity.Role;
import com.tz.cms.sysmgr.entity.RoleToArea;
import com.tz.cms.sysmgr.entity.RoleToDept;
import com.tz.cms.sysmgr.entity.RoleToMenu;
import com.tz.cms.sysmgr.mapper.RoleMapper;
import com.tz.cms.sysmgr.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/13 9:12
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> getAllRoleList() {
        return roleMapper.getAllRoleList();
    }

    @Override
    public List<RoleToMenu> getRoleToMenuById(Long roleId) {
        return roleMapper.getRoleToMenuById(roleId);
    }

    @Override
    public List<RoleToDept> getRoleToDeptById(Long roleId) {
        return roleMapper.getRoleToDeptById(roleId);
    }

    @Override
    public List<RoleToArea> getRoleToAreaById(Long roleId) {
        return roleMapper.getRoleToAreaById(roleId);
    }



    @Override
    public int insertRoleDto(RoleDto roleDto) {
        // 增加角色
        Role role = roleDto.getRole();
        role.setUpdateBy(UserUtils.getCurrrentUserId()+"");
        role.setUpdateDate(new Date());
        int i = 0;
        if(role != null){
            // 修改
            if(role.getId() != null){
                i = roleMapper.updateByPrimaryKeySelective(role);
                roleMapper.deleteRoleToMenu(role.getId());
                roleMapper.deleteRoleToDept(role.getId());
                roleMapper.deleteRoleToArea(role.getId());
            }else{
                // 新增
                i = roleMapper.insertSelective(role);
            }

            // 增加角色-菜单
            Map<Long,Long> roleToMenus = roleDto.getMenuIds();
            List<RoleToMenu> roleToMenuList = new ArrayList<RoleToMenu>();
            for(Long key : roleToMenus.keySet()){
                RoleToMenu roleToMenu = new RoleToMenu();
                roleToMenu.setRoleId(role.getId());
                roleToMenu.setMenuId(key);
                roleToMenuList.add(roleToMenu);
            }
            roleMapper.batchInsertRoleToMenu(roleToMenuList);

            // 增加角色-部门
            Map<Long,Long> roleToDepts = roleDto.getDeptIds();
            List<RoleToDept> roleToDeptList = new ArrayList<RoleToDept>();
            for(Long key : roleToDepts.keySet()){
                RoleToDept roleToDept = new RoleToDept();
                roleToDept.setRoleId(role.getId());
                roleToDept.setDeptId(key);
                roleToDeptList.add(roleToDept);
            }
            roleMapper.batchInsertRoleToDept(roleToDeptList);

            // 增加角色-区域
            Map<Long,Long> roleToAreas = roleDto.getAreaIds();
            List<RoleToArea> roleToAreaList = new ArrayList<RoleToArea>();
            for(Long key : roleToAreas.keySet()){
                RoleToArea roleToArea = new RoleToArea();
                roleToArea.setRoleId(role.getId());
                roleToArea.setAreaId(key);
                roleToAreaList.add(roleToArea);
            }
            roleMapper.batchInsertRoleToArea(roleToAreaList);
        }

        return i;
    }

    @Override
    public int deleteRole(Long id) {
        // 删除中间表
        roleMapper.deleteRoleToMenu(id);
        roleMapper.deleteRoleToDept(id);
        roleMapper.deleteRoleToArea(id);
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        record.setUpdateBy(UserUtils.getCurrrentUserId()+"");
        record.setUpdateDate(new Date());
        return roleMapper.updateByPrimaryKeySelective(record);
    }
}
