package com.tz.cms.sysmgr;

import com.tz.cms.sysmgr.entity.Area;
import com.tz.cms.sysmgr.service.IAreaService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/24 9:12
 */
public class AreaTestTwo {

    @Test
    public void testArea2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
        IAreaService areaService = (IAreaService)ac.getBean("areaService");
        List<Area> areaList = areaService.getAllAreaList();
        for(Area area:areaList){
            System.out.println("areaId = "+area.getAreaId());
        }
    }

}
