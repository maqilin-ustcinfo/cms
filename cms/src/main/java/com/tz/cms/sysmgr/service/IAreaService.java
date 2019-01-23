package com.tz.cms.sysmgr.service;

import com.tz.cms.sysmgr.entity.PmSysArea;

import java.util.List;

public interface IAreaService {
    /**
     * 获取所有的区域
     *
     * @Return List<PmSysArea>区域集合
     */
    List<PmSysArea> getAllAreaList();
}
