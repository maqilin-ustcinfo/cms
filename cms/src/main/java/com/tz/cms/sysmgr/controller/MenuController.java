package com.tz.cms.sysmgr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.cms.framework.util.TreeUtils;
import com.tz.cms.sysmgr.entity.Menu;
import com.tz.cms.sysmgr.service.IMenuService;

@Controller
@RequestMapping("/sysmgr/menu")
public class MenuController {
	
	private static Logger logger = Logger.getLogger(MenuController.class);
	
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping("/gotoMenuList")
	public String gotoMenuList(Model model) {
		// 查询所有的菜单
		List<Menu> menuList = menuService.getAllMenuList();
		/*
		 * // 排序 List<Menu> sortMenuList = new ArrayList<Menu>();
		 * TreeUtils.sortMenuList(menuList, sortMenuList, 0L);
		 * System.out.println("sortMenuList="+sortMenuList);
		 */
		model.addAttribute("menuList", menuList);
		return "sysmanage/menu/menuList";
	}
	
	@RequestMapping("/delMenu")
	@ResponseBody
	public Map<String,Object> delMenu(Long menuId) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		// 判断是否有子菜单
		if(menuService.getCountByParentId(menuId) > 0) {
			resultMap.put("result", "请先删除其子菜单，再删除该菜单");
			return resultMap;
		}
		// 删除
		if(menuService.deleteByPrimaryKey(menuId) > 0) {
			resultMap.put("result", "删除成功");
		}
		
		return resultMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
