package com.tz.cms.framework.util;

import java.util.List;

import com.tz.cms.sysmgr.entity.Menu;

public class TreeUtils {
	
	
	/**
	 * 排序
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static void sortTree(List<Menu> menuList,List<Menu> sortMenuList,Long parentId) {
		if(menuList == null || sortMenuList == null || parentId == null) {
			return;
		}
		for(Menu menu : menuList) {
			if(parentId.equals(menu.getParentId())) {
				sortMenuList.add(menu);
				for(Menu childMenu : menuList) {
					if(parentId.equals(childMenu.getParentId())) {
						sortTree(menuList,sortMenuList,menu.getId());
						break;
					}
				}
				
			}
		}
	}
	
	public static void sortMenuList(List<Menu> menuList,List<Menu> sortMenuList,
					Long parentId){
			for(Menu menu :menuList){
			if(menu.getParentId()!=null&&menu.getParentId().equals(parentId)){
			sortMenuList.add(menu);
			for(Menu childMenu: menuList){
				if(childMenu.getParentId()!=null&&childMenu.getParentId().equals(parentId)){
					//递归
					sortMenuList(sortMenuList,menuList,menu.getId());
					break;
				}
			}
			
			}
			}		
		}

}
