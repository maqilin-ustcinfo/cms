package com.tz.cms.sysmgr.service.impl;

import com.tz.cms.framework.util.UserUtils;
import com.tz.cms.sysmgr.entity.Area;
import com.tz.cms.sysmgr.mapper.AreaMapper;
import com.tz.cms.sysmgr.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/11 14:56
 */
@Service
public class AreaService implements IAreaService {

    @Autowired
    AreaMapper areaMapper;

    @Override
    public Area selectByPrimaryKey(Long id) {
        return areaMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Area> getChildNodeByParentId(Long parentId) {
        return areaMapper.getChildNodeByParentId(parentId);
    }

    @Override
    public List<Area> getAllAreaList() {
        return areaMapper.getAllAreaList();
    }

    @Override
    public Integer getCountByParentId(Long parentId) {
        return areaMapper.getCountByParentId(parentId);
    }

    @Override
    public Integer insertSelective(Area record) {
        record.setUpdateBy(UserUtils.getCurrrentUserId()+"");
        record.setUpdateDate(new Date());
        return areaMapper.insertSelective(record);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return areaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(Area record) {
        record.setUpdateBy(UserUtils.getCurrrentUserId()+"");
        record.setUpdateDate(new Date());
        return areaMapper.updateByPrimaryKeySelective(record);
    }
}
