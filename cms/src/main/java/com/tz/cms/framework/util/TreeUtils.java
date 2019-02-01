package com.tz.cms.framework.util;

import java.util.List;
import java.util.Map;

import com.tz.cms.sysmgr.entity.Menu;
/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
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

	


	/**
	 * 找到所有的子代放入Map
	 */
	public static void getAllChildMap(List<Menu> menuList, Map<Long,Menu> map,Long id){
		for(Menu menu : menuList){
			// 所有子代
			if(menu.getParentId().longValue() == id.longValue()){
				map.put(menu.getId(),menu);
				getAllChildMap(menuList,map,menu.getId());
			}
		}
	}

}
