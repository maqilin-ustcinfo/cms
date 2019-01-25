package com.tz.cms.sysmgr.service;

import com.tz.cms.sysmgr.entity.Area;

import java.util.List;
/**
 * 区域 class
 *
 * @author maqilin
 * @date 2016/10/31
 */
public interface IAreaService {

    /**
     * 获取所有的区域信息
     *
     * @return List<Area>
     */
    List<Area> getAllAreaList();

    /**
     * 更新区域信息
     * @param areaId
     * @param remarks
     * @return List<Area>
     */
    int updateAreaById(Integer areaId,String remarks);

    /**
     * 更新区域信息
     * @param areaId
     * @param remarks
     * @return List<Area>
     */
    int updateAreaFlagById(Integer areaId,String remarks);
}
