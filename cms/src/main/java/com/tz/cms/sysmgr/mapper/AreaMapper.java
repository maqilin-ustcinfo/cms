package com.tz.cms.sysmgr.mapper;

import com.tz.cms.sysmgr.dto.AreaDto;
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

    /**
     * 根据区域ID更新区域备注
     * @param areaId
     * @param remarks
     * @return List<Area>
     */
    int updateAreaById(Integer areaId,String remarks);

    /**
     * 根据区域ID更新区域删除标识
     * @param areaId
     * @param delFlag
     * @return List<Area>
     */
    int updateAreaFlagById(Integer areaId,String delFlag);

    /**
     * 根据区域ID获取区域信息
     * @param areaId
     * @return List<Area>
     */
    Area getAreaById(Integer areaId);

    /**
     * 根据条件获取区域信息
     * @param area
     * @return List<Area>
     */
    List<Area> getAreaListByRntity(Area area);

    /**
     * 根据条件获取区域信息
     * @param area
     * @return List<Area>
     */
    int addArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return List<Area>
     */
    int delAreaById(Integer areaId);

    /**
     * 更新区域信息
     * @param area
     * @return List<Area>
     */
    int updateArea(Area area);

    /**
     * 利用包装类查询区域信息
     * @param areaDto
     * @return List<Area>
     */
    List<Area> getAreaListByDto(AreaDto areaDto);

    /**
     * 统计数量
     * @return List<Area>
     */
    int getCount();

}
