package com.tz.cms.sysmgr.service.impl;

import com.tz.cms.sysmgr.entity.Area;
import com.tz.cms.sysmgr.mapper.AreaMapper;
import com.tz.cms.sysmgr.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author maqilin
 * @description: 区域信息服务层
 * @date 2019/1/23 15:31
 */
@Service
public class AreaService implements IAreaService {

    @Autowired
    AreaMapper areaMapper;

    @Override
    public List<Area> getAllAreaList() {
        return areaMapper.getAllAreaList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int updateAreaById(Integer areaId, String remarks) {
        int i = areaMapper.updateAreaById(areaId,remarks);
        int j = this.updateAreaFlagById(areaId,"1");
        return i+j;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateAreaFlagById(Integer areaId, String delFalg) {
        int i = areaMapper.updateAreaFlagById(areaId,delFalg);
        return i;
    }
}
