package com.tz.cms.sysmgr.service.impl;

import com.tz.cms.sysmgr.entity.PmSysArea;
import com.tz.cms.sysmgr.mapper.AreaMapper;
import com.tz.cms.sysmgr.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<PmSysArea> getAllAreaList() {
        return areaMapper.getAllAreaList();
    }
}
