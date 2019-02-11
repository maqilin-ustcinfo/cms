package com.tz.cms.sysmgr.controller;

import com.tz.cms.framework.util.TreeUtils;
import com.tz.cms.sysmgr.entity.Area;
import com.tz.cms.sysmgr.service.IAreaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/sysmgr/area")
public class AreaController {
	
	private static Logger logger = Logger.getLogger(AreaController.class);
	
	@Autowired
	private IAreaService areaService;

	/**
	 * 进入部门列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/gotoAreaList")
	public String gotoAreaList(Model model) {
		// 查询所有的部门
		List<Area> AreaList = areaService.getAllAreaList();
	    List<Area> sortAreaList = new ArrayList<Area>();
	    TreeUtils.sortTreeNew(AreaList, sortAreaList, new Long(0L));
		model.addAttribute("areaList", sortAreaList);
		return "sysmanage/area/areaList";
	}

	/**
	 * 进入区域添加/修改页面
	 * @param editFlag = 1 添加
	 * @param parentId 添加下级区域有值
	 * @param areaId 修改时候有值
	 * @return
	 */
	@RequestMapping("/gotoAreaEdit")
	public String gotoMenuEdit(@ModelAttribute("editFlag") int editFlag, Long parentId,
							   Long areaId, Model model) {
		// 添加下级区域
		if(editFlag == 1 && parentId != null){
			Area area = areaService.selectByPrimaryKey(parentId);
			Area m = new Area();
			m.setParentName(area.getName());
			m.setParentId(area.getId());
			model.addAttribute("area",m);
		}
		// 修改
		if(editFlag == 2){
			Area Area = areaService.selectByPrimaryKey(areaId);
			model.addAttribute("area",Area);
		}

		return "sysmanage/area/areaEdit";
	}

	/**
	 * ztree获取数据
	 * @return
	 */
	@RequestMapping("/getParentAreaTreeData")
	@ResponseBody
	public List<Area> getParentMenuTreeData(@RequestParam("areaId") Long areaId){
		// 查询所有区域
		List<Area> areaList = areaService.getAllAreaList();
		logger.info("areaId=="+areaId);
		// 找到所有的后代区域
		if(areaId != null){
			Map<Long,Area> resultMap = new HashMap<Long,Area>();
			// 子代
			TreeUtils.getAllChildMapNew(areaList,resultMap,areaId);
			// 本身
			resultMap.put(areaId,areaService.selectByPrimaryKey(areaId));
			// 从areaList去除这些数据
			Iterator<Area> iterator = areaList.iterator();
			while(iterator.hasNext()){
				Area m = iterator.next();
				if(resultMap.containsKey(m.getId())){
					iterator.remove();
				}
			}
		}
		return areaList;
	}

	/**
	 * 保存区域
	 * @param
	 * @return
	 */
	@RequestMapping("/saveArea")
	@ResponseBody
	public Map<String,Object> saveMenu(@RequestBody Area area) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//增加
		if(area != null && area.getId() == null){
			areaService.insertSelective(area);
			resultMap.put("result", "增加区域成功");
		}
		//修改
		if(area !=null && area.getId() != null){
			areaService.updateByPrimaryKeySelective(area);
			resultMap.put("result", "修改区域成功");
		}
		return resultMap;
	}
	
	@RequestMapping("/delArea")
	@ResponseBody
	public Map<String,Object> delMenu(Long areaId) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		// 判断是否有子区域
		if(areaService.getCountByParentId(areaId) > 0) {
			resultMap.put("result", "请先删除其子区域，再删除该区域");
			return resultMap;
		}
		// 删除
		if(areaService.deleteByPrimaryKey(areaId) > 0) {
			resultMap.put("result", "删除成功");
		}
		
		return resultMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
