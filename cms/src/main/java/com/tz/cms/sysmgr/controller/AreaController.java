package com.tz.cms.sysmgr.controller;

import com.tz.cms.sysmgr.entity.PmSysArea;
import com.tz.cms.sysmgr.service.impl.AreaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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


    @RequestMapping("/getAllAreaList")
    public String getAllAreaList(){
        List<PmSysArea> areaList = areaService.getAllAreaList();
        logger.info("获取到的区域信息个数："+areaList.size());
        return "success";
    }

}
