package com.tz.cms.sysmgr.controller;

import java.util.*;

import com.tz.cms.framework.util.UserUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tz.cms.framework.util.TreeUtils;
import com.tz.cms.sysmgr.entity.Menu;
import com.tz.cms.sysmgr.service.IMenuService;

@Controller
@RequestMapping("/sysmgr/menu")
public class MenuController {
	
	private static Logger logger = Logger.getLogger(MenuController.class);
	
	@Autowired
	private IMenuService menuService;

	/**
	 * 进入菜单列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/gotoMenuList")
	public String gotoMenuList(Model model) {
		// 查询所有的菜单
		List<Menu> menuList = menuService.getAllMenuList();
	    List<Menu> sortMenuList = new ArrayList<Menu>();
	    TreeUtils.sortTree(menuList, sortMenuList, new Long(0L));
		model.addAttribute("menuList", sortMenuList);
		return "sysmanage/menu/menuList";
	}

	/**
	 * 进入菜单添加/修改页面
	 * @param editFlag = 1 添加
	 * @param parentId 添加下级菜单有值
	 * @param menuId 修改时候有值
	 * @return
	 */
	@RequestMapping("/gotoMenuEdit")
	public String gotoMenuEdit(@ModelAttribute("editFlag") int editFlag, Long parentId,
							   Long menuId, Model model) {
		// 添加下级菜单
		if(editFlag == 1 && parentId != null){
			Menu menu = menuService.selectByPrimaryKey(parentId);
			Menu m = new Menu();
			m.setParentName(menu.getName());
			m.setParentId(menu.getId());
			model.addAttribute("menu",m);
		}
		// 修改
		if(editFlag == 2){
			Menu menu = menuService.selectByPrimaryKey(menuId);
			model.addAttribute("menu",menu);
		}

		return "sysmanage/menu/menuEdit";
	}

	/**
	 * ztree获取数据
	 * @return
	 */
	@RequestMapping("/getParentMenuTreeData")
	@ResponseBody
	public List<Menu> getParentMenuTreeData(@RequestParam("menuId") Long menuId){
		System.out.println("go to getParentMenuTreeData:"+menuId);
		// 查询所有菜单
		List<Menu> menuList = menuService.getAllMenuList();
		// 找到所有的后代菜单
		if(menuId != null){
			Map<Long,Menu> resultMap = new HashMap<Long,Menu>();
			// 子代
			TreeUtils.getAllChildMap(menuList,resultMap,menuId);
			// 本身
			resultMap.put(menuId,menuService.selectByPrimaryKey(menuId));
			// 从menuList去除这些数据
			Iterator<Menu> iterator = menuList.iterator();
			while(iterator.hasNext()){
				Menu m = iterator.next();
				if(resultMap.containsKey(m.getId())){
					iterator.remove();
				}
			}
		}
		return menuList;
	}

	/**
	 * 保存菜单
	 * @param
	 * @return
	 */
	@RequestMapping("/saveMenu")
	@ResponseBody
	public Map<String,Object> saveMenu(@RequestBody Menu menu) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//增加
		if(menu != null && menu.getId() == null){
			menu.setUpdateBy(UserUtils.getCurrrentUserId()+"");
			menu.setUpdateDate(new Date());
			menuService.insertSelective(menu);
			resultMap.put("result", "增加菜单成功");
		}
		//修改
		if(menu !=null && menu.getId() != null){
			menu.setUpdateBy(UserUtils.getCurrrentUserId()+"");
			menu.setUpdateDate(new Date());
			menuService.updateByPrimaryKeySelective(menu);
			resultMap.put("result", "修改菜单成功");
		}

		return resultMap;
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
