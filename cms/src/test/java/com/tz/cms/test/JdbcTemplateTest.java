package com.tz.cms.test;

import com.tz.cms.test.dao.impl.AreaDao;
import com.tz.cms.test.service.impl.AreaServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author maqilin
 * @description: spring jdbcTemplate测试
 * @date 2019/1/24 10:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class JdbcTemplateTest {

    @Autowired
    AreaDao areaDao;

    @Resource
    AreaServiceTest areaServiceTest;

    @Test
    public void testQueryAll(){
        List<Map<String,Object>> areaList = areaDao.getAreaAllList();
        for(Map<String,Object> area : areaList){
            System.out.println(area);
        }
    }
    @Test
    public void testQueryObject(){
        Map<String,Object> area = areaDao.getAreaById(1);
        System.out.println(area);
    }

    @Test
    public void testUpdate(){
        areaDao.uptAreaById("remaks",1);
    }

    @Test
    public void testGetAll(){
        areaServiceTest.getAreaAllList();
    }


}
