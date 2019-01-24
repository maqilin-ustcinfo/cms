package com.tz.cms.sysmgr;

import com.tz.cms.sysmgr.entity.Area;
import com.tz.cms.sysmgr.service.IAreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/24 9:12
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring-beans.xml"}) //加载配置文件
public class AreaTest {

    @Autowired
    IAreaService areaService;

    @Test
    @Transactional
    public void testArea(){
        List<Area> areaList = areaService.getAllAreaList();
        for(Area area:areaList){
            System.out.println("areaId = "+area.getAreaId());
        }
    }

}
