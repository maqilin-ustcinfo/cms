package com.tz.cms.sysmgr.controller;

import com.tz.cms.sysmgr.entity.Area;
import com.tz.cms.sysmgr.service.impl.AreaService;
import com.tz.cms.test.service.IAreaServiceTest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author maqilin
 * @description: 区域控制层
 * @date 2019/1/23 15:33
 */
@Controller
@RequestMapping("/sysmgr")
public class AreaController {

    private static Logger logger = Logger.getLogger(AreaController.class);

    @Autowired
    AreaService areaService;

    @Autowired
    IAreaServiceTest areaServiceTest;


    @RequestMapping("/getAllAreaList")
    public String getAllAreaList(){
        List<Map<String,Object>> areaList = areaServiceTest.getAreaAllList();
        logger.info("获取到的区域信息个数："+areaList.size());
        return "success";
    }


}
