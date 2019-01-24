package com.tz.cms.test.service.impl;

import com.tz.cms.test.dao.impl.AreaDao;
import com.tz.cms.test.service.IAreaServiceTest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/24 11:48
 */
@Service
public class AreaServiceTest implements IAreaServiceTest {

    private static Logger logger = Logger.getLogger(AreaServiceTest.class);

    @Resource
    AreaDao areaDao;

    @Override
    public List<Map<String, Object>> getAreaAllList() {
        logger.debug("进入getAreaAllList service");
        List<Map<String, Object>> mapList = null;
        try {
            mapList = areaDao.getAreaAllList();
            //int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //int j = 1/0;
        logger.debug("执行完成getAreaAllList service");
        return mapList;
    }
}
