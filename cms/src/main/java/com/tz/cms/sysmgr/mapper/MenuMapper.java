package com.tz.cms.sysmgr.mapper;

import java.util.List;

import com.tz.cms.sysmgr.entity.Menu;

public interface MenuMapper {
	
	/**
	 * 查询菜单By id
	 * @param id
	 * @return
	 */
	Menu selectByPrimaryKey(Long id);


	/**
	 * 根据parentId得到子菜单
	 * @param parentId
	 * @return
	 */
	List<Menu> getChildNodeByParentId(Long parentId);
	
	/**
	 * 查询所有菜单
	 * @return
	 */
	List<Menu> getAllMenuList();

	/**
	 * 根据用户ID查询当前登陆用户有那些菜单
	 * @param userId
	 * @return
	 */
	List<Menu> getMenuListByUserId(Long userId);
	
	/**
	 * 统计一个节点下的子节点数量
	 * @param parentId
	 * @return
	 */
	Integer getCountByParentId(Long parentId);
	
	/**
	 * 增加菜单
	 * @param record
	 * @return
	 */
	Integer insertSelective(Menu record);

	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	Integer deleteByPrimaryKey(Long id);

    
    /**
	 * 更新菜单
     * @param record
     * @return
     */
    Integer updateByPrimaryKeySelective(Menu record);

}