package com.tz.cms.sysmgr.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.tz.cms.framework.dto.PageParam;
import com.tz.cms.framework.util.PageUtils;
import com.tz.cms.framework.util.UserUtils;
import com.tz.cms.sysmgr.entity.Dict;
import com.tz.cms.sysmgr.service.IDictService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maqilin
 * @description: 字典控制类
 * @date 2019/1/31 10:26
 */
@Controller
@RequestMapping("/sysmgr/dict")
public class DictController {

    private static Logger logger = Logger.getLogger(DictController.class);

    @Autowired
    IDictService dictService;

    /**
     * 进入字典列表页面
     * @return
     */
    @RequestMapping("/gotoDictList")
    public String gotoDictList(Model model){
        // 查询所有的字典类型
        List<String> dictTypeList = dictService.getAllDictType();
        model.addAttribute("dictTypeList",dictTypeList);
        return "sysmanage/dict/dictList";
    }

    /**
     * 获取dictList
     * @return
     */
    @RequestMapping("/getDictList")
    @ResponseBody
    public Map<String,Object> getDictList(String type,String description){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        Dict dict = new Dict();
        if(StringUtils.isNoneEmpty(type)){
            dict.setType(type);
        }
        if(StringUtils.isNoneEmpty(description)){
            dict.setDescription(description);
        }
        List<Dict> dictList = dictService.getDictListByEntity(dict);
        resultMap.put("dictList",dictList);
        return resultMap;
    }

    /**
     * 分页获取dictList
     * @return
     */
    @RequestMapping("/getDictListPage")
    @ResponseBody
    public Map<String,Object> getDictListPage(String type,String description,
                                              Integer pageNo,Integer pageSize){
        Map<String,Object> resultMap = new HashMap<String,Object>();

        Dict dict = new Dict();
        if(StringUtils.isNoneEmpty(type)){
            dict.setType(type);
        }
        if(StringUtils.isNoneEmpty(description)){
            dict.setDescription(description);
        }

        PageParam pageParam = new PageParam();
        if(pageNo != null){
            pageParam.setPageNo(pageNo);
        }
        if(pageSize != null){
            pageParam.setPageSize(pageSize);
        }
        PageInfo<Dict> pageInfo = dictService.getDictListByEntityPage(dict,pageParam);
        // 返回的分页数据
        resultMap.put("dictList",pageInfo.getList());
        // 返回的分页信息
        String pageStr = PageUtils.pageStr(pageInfo,"dictMgr.getDictListPage");
        resultMap.put("pageStr",pageStr);
        return resultMap;
    }

    /**
     * 进入添加/修改页面
     * @return
     */
    @RequestMapping("/gotoDictEdit")
    public String gotoDictEdit(@ModelAttribute("editFlag") int editFlag,Integer dictId,Model model){

        // 修改根据ID查询
        if(editFlag == 2){
            Dict dict = dictService.selectDictById(dictId);
            model.addAttribute("dict",dict);
        }
        return "sysmanage/dict/dictEdit";
    }

    /**
     * 保存字段值
     * @return
     */
    @RequestMapping("/saveDict")
    @ResponseBody
    public Map<String,Object> saveDict(@RequestBody Dict dict){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        Integer dictId = dict.getId();
        try {
            if(dictId == null){
                // 新增
                dict.setUpdateBy(UserUtils.getCurrrentUserId()+"");
                dict.setUpdateDate(new Date());
                dictService.addDict(dict);
                resultMap.put("result","新增字典成功");
            }else{
                // 修改
                dict.setUpdateBy(UserUtils.getCurrrentUserId()+"");
                dict.setUpdateDate(new Date());
                dictService.updateDict(dict);
                resultMap.put("result","修改字典成功");
            }
        } catch (Exception e) {
            logger.error("保存字典异常",e);
            resultMap.put("result","保存字典异常");
        }
        return resultMap;
    }

    @RequestMapping("/delDict")
    @ResponseBody
    public Map<String,Object> delDict(Integer dictId){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        int i = dictService.deleteDict(dictId);
        if(i > 0){
            resultMap.put("result","删除成功");
        }
        return resultMap;
    }

}
