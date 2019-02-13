package com.tz.cms.sysmgr.service;

import com.tz.cms.sysmgr.dto.RoleDto;
import com.tz.cms.sysmgr.entity.Role;
import com.tz.cms.sysmgr.entity.RoleToArea;
import com.tz.cms.sysmgr.entity.RoleToDept;
import com.tz.cms.sysmgr.entity.RoleToMenu;

import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/13 9:12
 */
public interface IRoleService {
    /**
     * 通过id查询角色
     * @param id
     * @return
     */
    Role selectByPrimaryKey(Long id);

    /**
     * 查询所有角色列表
     * @return
     */
    List<Role> getAllRoleList();

    /**
     * 查询角色菜单
     * @param roleId
     */
    List<RoleToMenu> getRoleToMenuById(Long roleId);

    /**
     * 查询角色部门
     * @param roleId
     */
    List<RoleToDept> getRoleToDeptById(Long roleId);

    /**
     * 查询角色区域
     * @param roleId
     */
    List<RoleToArea> getRoleToAreaById(Long roleId);

    /**
     * 新增角色
     * @param roleDto
     * @return
     */
    int insertRoleDto(RoleDto roleDto);

    /**
     *  删除角色
     * @param id
     * @return
     */
    int deleteRole(Long id);

    /**
     * 修改角色
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Role record);
}
