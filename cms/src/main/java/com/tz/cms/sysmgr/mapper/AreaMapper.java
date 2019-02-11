package com.tz.cms.sysmgr.mapper;

import com.tz.cms.sysmgr.entity.Area;

import java.util.List;
/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
public interface AreaMapper {
    /**
     * 查询区域By id
     * @param id
     * @return
     */
    Area selectByPrimaryKey(Long id);


    /**
     * 根据parentId得到子区域
     * @param parentId
     * @return
     */
    List<Area> getChildNodeByParentId(Long parentId);

    /**
     * 查询所区域有
     * @return
     */
    List<Area> getAllAreaList();

    /**
     * 统计一个节点下的子节点数量
     * @param parentId
     * @return
     */
    Integer getCountByParentId(Long parentId);

    /**
     * 增加区域
     * @param record
     * @return
     */
    Integer insertSelective(Area record);

    /**
     * 删除区域
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Long id);


    /**
     * 更新区域
     * @param record
     * @return
     */
    Integer updateByPrimaryKeySelective(Area record);
}