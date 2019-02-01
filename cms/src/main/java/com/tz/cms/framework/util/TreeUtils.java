package com.tz.cms.framework.util;

import java.util.List;
import java.util.Map;

import com.tz.cms.framework.dto.TreeDto;
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
	
	// 排序
	public static <T> void sortTreeNew(List<T> treeList,
						List<T> sortTreeDtoList,Long parentId) {
		for(int i=0;i<treeList.size();i++){
			TreeDto tree = (TreeDto)treeList.get(i);
			if(parentId.equals(tree.getParentId())) {
				sortTreeDtoList.add((T)tree);
				for(int j=0;i<treeList.size();j++){
					TreeDto childTree = (TreeDto)treeList.get(j);
					if(parentId.equals(childTree.getParentId())){
						sortTreeNew(treeList,sortTreeDtoList,tree.getId());
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
	
	/**
	 * 找到所有的子代放入Map
	 */
	public static <T> void  getAllChildMapNew(List<T> treeList, Map<Long,T> map,Long id){
		for(int i=0;i<treeList.size();i++){
			TreeDto tree = (TreeDto)treeList.get(i);
			// 所有子代
			if(tree.getParentId().longValue() == id.longValue()){
				map.put(tree.getId(),(T)tree);
				getAllChildMapNew(treeList,map,tree.getId());
			}
		}
	}

}
