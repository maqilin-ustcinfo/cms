package com.tz.cms.sysmgr.controller;

import com.tz.cms.framework.util.TreeUtils;
import com.tz.cms.framework.util.UserUtils;
import com.tz.cms.sysmgr.entity.Dept;
import com.tz.cms.sysmgr.entity.Menu;
import com.tz.cms.sysmgr.service.IDeptService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/sysmgr/dept")
public class DeptController {
	
	private static Logger logger = Logger.getLogger(DeptController.class);
	
	@Autowired
	private IDeptService deptService;

	/**
	 * 进入部门列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/gotoDeptList")
	public String gotoMenuList(Model model) {
		// 查询所有的部门
		List<Dept> deptList = deptService.getAllDeptList();
	    List<Dept> sortDeptList = new ArrayList<Dept>();
	    TreeUtils.sortTreeNew(deptList, sortDeptList, new Long(0L));
		model.addAttribute("deptList", sortDeptList);
		return "sysmanage/dept/deptList";
	}

	/**
	 * 进入菜单添加/修改页面
	 * @param editFlag = 1 添加
	 * @param parentId 添加下级菜单有值
	 * @param deptId 修改时候有值
	 * @return
	 */
	@RequestMapping("/gotoDeptEdit")
	public String gotoMenuEdit(@ModelAttribute("editFlag") int editFlag, Long parentId,
							   Long deptId, Model model) {
		// 添加下级菜单
		if(editFlag == 1 && parentId != null){
			Dept dept = deptService.selectByPrimaryKey(parentId);
			Dept m = new Dept();
			m.setParentName(dept.getName());
			m.setParentId(dept.getId());
			model.addAttribute("dept",m);
		}
		// 修改
		if(editFlag == 2){
			Dept dept = deptService.selectByPrimaryKey(deptId);
			model.addAttribute("dept",dept);
		}

		return "sysmanage/dept/deptEdit";
	}

	/**
	 * ztree获取数据
	 * @return
	 */
	@RequestMapping("/getParentDeptTreeData")
	@ResponseBody
	public List<Dept> getParentMenuTreeData(@RequestParam("deptId") Long deptId){
		// 查询所有菜单
		List<Dept> deptList = deptService.getAllDeptList();
		// 找到所有的后代菜单
		if(deptId != null){
			Map<Long,Dept> resultMap = new HashMap<Long,Dept>();
			// 子代
			TreeUtils.getAllChildMapNew(deptList,resultMap,deptId);
			// 本身
			resultMap.put(deptId,deptService.selectByPrimaryKey(deptId));
			// 从menuList去除这些数据
			Iterator<Dept> iterator = deptList.iterator();
			while(iterator.hasNext()){
				Dept m = iterator.next();
				if(resultMap.containsKey(m.getId())){
					iterator.remove();
				}
			}
		}
		return deptList;
	}

	/**
	 * 保存菜单
	 * @param
	 * @return
	 */
	@RequestMapping("/saveDept")
	@ResponseBody
	public Map<String,Object> saveMenu(@RequestBody Dept dept) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//增加
		if(dept != null && dept.getId() == null){
			deptService.insertSelective(dept);
			resultMap.put("result", "增加部门成功");
		}
		//修改
		if(dept !=null && dept.getId() != null){
			deptService.updateByPrimaryKeySelective(dept);
			resultMap.put("result", "修改部门成功");
		}
		return resultMap;
	}
	
	@RequestMapping("/delDept")
	@ResponseBody
	public Map<String,Object> delMenu(Long deptId) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		// 判断是否有子菜单
		if(deptService.getCountByParentId(deptId) > 0) {
			resultMap.put("result", "请先删除其子部门，再删除该部门");
			return resultMap;
		}
		// 删除
		if(deptService.deleteByPrimaryKey(deptId) > 0) {
			resultMap.put("result", "删除成功");
		}
		
		return resultMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
