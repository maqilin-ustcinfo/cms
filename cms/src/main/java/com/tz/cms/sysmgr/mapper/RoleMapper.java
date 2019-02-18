package com.tz.cms.sysmgr.mapper;

import com.tz.cms.sysmgr.entity.Role;
import com.tz.cms.sysmgr.entity.RoleToArea;
import com.tz.cms.sysmgr.entity.RoleToDept;
import com.tz.cms.sysmgr.entity.RoleToMenu;

import java.util.List;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
public interface RoleMapper {

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
     * @param record
     * @return
     */
    int insertSelective(Role record);

    /**
     * 增加角色-菜单
     * @param roleToMenu
     */
    void insertRoleToMenu(RoleToMenu roleToMenu);

    /**
     * 增加角色-部门
     * @param roleToDept
     */
    void insertRoleToDept(RoleToDept roleToDept);

    /**
     * 增加角色-区域
     * @param roleToArea
     */
    void insertRoleToArea(RoleToArea roleToArea);


    /**
     * 批量增加角色-菜单
     * @param roleToMenuList
     */
    void batchInsertRoleToMenu(List<RoleToMenu> roleToMenuList);

    /**
     * 批量增加角色-部门
     * @param roleToDeptList
     */
    void batchInsertRoleToDept(List<RoleToDept> roleToDeptList);

    /**
     * 批量增加角色-区域
     * @param roleToAreaList
     */
    void batchInsertRoleToArea(List<RoleToArea> roleToAreaList);

    /**
     *  删除角色
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 删除角色菜单
     * @param roleId
     */
    void deleteRoleToMenu(Long roleId);

    /**
     * 删除角色菜单
     * @param menuId
     */
    void deleteRoleToMenuByMenuId(Long menuId);

    /**
     * 删除角色部门
     * @param deptId
     */
    void deleteRoleToDeptByDeptId(Long deptId);

    /**
     * 删除角色区域
     * @param areaId
     */
    void deleteRoleToAreaByAreaId(Long areaId);

    /**
     * 删除角色部门
     * @param roleId
     */
    void deleteRoleToDept(Long roleId);

    /**
     * 删除角色区域
     * @param roleId
     */
    void deleteRoleToArea(Long roleId);

    /**
     * 修改角色
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Role record);

}