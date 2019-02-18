package com.tz.cms.sysmgr.service.impl;

import java.util.List;

import com.tz.cms.sysmgr.entity.RoleToMenu;
import com.tz.cms.sysmgr.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.cms.sysmgr.entity.Menu;
import com.tz.cms.sysmgr.mapper.MenuMapper;
import com.tz.cms.sysmgr.service.IMenuService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuService implements IMenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Autowired
	RoleMapper roleMapper;

	@Override
	public Menu selectByPrimaryKey(Long id) {
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Menu> getAllMenuList() {
		return menuMapper.getAllMenuList();
	}

	@Override
	public List<Menu> getMenuListByUserId(Long userId) {
		return menuMapper.getMenuListByUserId(userId);
	}

	@Override
	public List<Menu> getChildNodeByParentId(Long parentId) {
		return menuMapper.getChildNodeByParentId(parentId);
	}

	@Override
	public Integer getCountByParentId(Long parentId) {
		return menuMapper.getCountByParentId(parentId);
	}

	@Override
	@Transactional
	public Integer insertSelective(Menu record) {
		int i = menuMapper.insertSelective(record);
		RoleToMenu roleToMenu = new RoleToMenu();
		roleToMenu.setMenuId(record.getId());
		roleToMenu.setRoleId(1L);
		roleMapper.insertRoleToMenu(roleToMenu);
		return i;
	}

	@Override
	@Transactional
	public Integer deleteByPrimaryKey(Long id) {
		roleMapper.deleteRoleToMenuByMenuId(id);
		return menuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Menu record) {
		return menuMapper.updateByPrimaryKeySelective(record);
	}

}
