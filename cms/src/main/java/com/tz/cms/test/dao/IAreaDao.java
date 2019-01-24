package com.tz.cms.test.dao;

import com.tz.cms.sysmgr.entity.Area;

import java.util.List;
import java.util.Map;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/24 10:15
 */
public interface IAreaDao {

    /**
     * fetch data by rule id
     * @return List<Map<String,Object>>
     */
    List<Map<String,Object>> getAreaAllList();

    /**
     * fetch data by rule id
     * @param areaId
     * @return Area
     */
    Map<String,Object> getAreaById(Integer areaId);

    /**
     * fetch data by rule id
     * @param areaId
     * @return Area
     */
    int uptAreaById(String remarks,Integer areaId);

}
