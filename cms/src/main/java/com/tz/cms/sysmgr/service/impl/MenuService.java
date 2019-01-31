package com.tz.cms.sysmgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.cms.sysmgr.entity.Menu;
import com.tz.cms.sysmgr.mapper.MenuMapper;
import com.tz.cms.sysmgr.service.IMenuService;

@Service
public class MenuService implements IMenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public Menu selectByPrimaryKey(Long id) {
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Menu> getAllMenuList() {
		return menuMapper.getAllMenuList();
	}

	@Override
	public Integer getCountByParentId(Long parentId) {
		return menuMapper.getCountByParentId(parentId);
	}

	@Override
	public Integer insertSelective(Menu record) {
		return menuMapper.insertSelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Long id) {
		return menuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Menu record) {
		return menuMapper.updateByPrimaryKeySelective(record);
	}

}
