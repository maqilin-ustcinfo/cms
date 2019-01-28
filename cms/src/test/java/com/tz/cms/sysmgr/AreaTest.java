package com.tz.cms.sysmgr;

import com.tz.cms.sysmgr.dto.AreaDto;
import com.tz.cms.sysmgr.dto.UserDto;
import com.tz.cms.sysmgr.entity.Area;
import com.tz.cms.sysmgr.mapper.AreaMapper;
import com.tz.cms.sysmgr.mapper.UserMapper;
import com.tz.cms.sysmgr.service.IAreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Autowired
    AreaMapper areaMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    @Transactional
    public void testArea(){
        List<Area> areaList = areaService.getAllAreaList();
        for(Area area:areaList){
            System.out.println("areaId = "+area.getAreaId());
        }
    }

    @Test
    public void testAreaUpdate(){
        int i = areaService.updateAreaById(1,"remarksa");
        System.out.println("更新区域信息成功："+i);
    }

    @Test
    public void getAreaById(){
        Area area = areaMapper.getAreaById(1);
        System.out.println("area="+area);
    }

    @Test
    public void getAreaListByRntity(){
        Area a = new Area();
        a.setSort(10);
        a.setAreaId(2);
        List<Area> areaList = areaMapper.getAreaListByRntity(a);
        for(Area aa :areaList){
            System.out.println(aa);
        }
    }

    @Test
    public void getAreaListByDto(){
        AreaDto dto = new AreaDto();
        Area a = new Area();
        a.setSort(10);
        a.setAreaId(2);
        dto.setArea(a);
        List<Area> areaList = areaMapper.getAreaListByDto(dto);
        for(Area aa :areaList){
            System.out.println(aa);
        }
    }

    @Test
    public void getResultMap(){
        List<Area> areaList = areaMapper.getResultMap();
        for(Area aa :areaList){
            System.out.println(aa);
        }
    }

    @Test
    public void getUserListMap(){
        List<Map<String,Object>> areaList = areaMapper.getUserListMap();
        for(Map<String,Object> aa :areaList){
            System.out.println("getUserListMap="+aa);
        }
    }

    @Test
    public void getCount(){
        System.out.println("==="+areaMapper.getCount());
    }

    @Test
    public void testAddArea(){
        Area a = new Area();
        a.setAreaId(3);
        a.setAreaName("重庆");
        a.setSort(10);
        a.setParentId(1);
        a.setAreaCode("231");
        a.setUpdateBy("1");
        a.setUpdateTime(new Date());
        int i = areaMapper.addArea(a);
        System.out.println("i="+i);
    }

    @Test
    public void delArea(){
        int i = areaMapper.delAreaById(3);
        System.out.println("i="+i);
    }

    @Test
    public void updateArea(){
        Area a = new Area();
        a.setAreaId(3);
        a.setAreaName("重庆1");
        a.setSort(100);
        a.setParentId(1);
        a.setAreaCode("333");
        a.setUpdateBy("1");
        a.setUpdateTime(new Date());
        int i = areaMapper.updateArea(a);
        System.out.println("i="+i);
    }

    @Test
    public void testGetUserDtoById(){
        UserDto userDto = userMapper.getUserDtoById(1);
        System.out.println("userDto="+userDto);
    }

    @Test
    public void testGetUserDtoById2(){
        UserDto userDto = userMapper.getUserDtoById2(1);
        System.out.println("userDto="+userDto);
    }

}
