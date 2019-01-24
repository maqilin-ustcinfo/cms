package com.tz.cms.sysmgr.mapper;

import com.tz.cms.sysmgr.entity.Area;

import java.util.List;
/**
 * 区域 class
 *
 * @author maqilin
 * @date 2016/10/31
 */
public interface AreaMapper {

    /**
     * 获取所有的区域信息
     *
     * @return List<Area>
     */
    List<Area> getAllAreaList();

}
