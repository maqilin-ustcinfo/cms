package com.tz.cms.sysmgr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tz.cms.framework.dto.PageParam;
import com.tz.cms.sysmgr.entity.Dict;
import com.tz.cms.sysmgr.mapper.DictMapper;
import com.tz.cms.sysmgr.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/31 10:23
 */

@Service
public class DictService implements IDictService {

    @Autowired
    DictMapper dictMapper;

    @Override
    public int addDict(Dict record) {
        return dictMapper.insertSelective(record);
    }

    @Override
    public int deleteDict(Integer id) {
        return dictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateDict(Dict record) {
        return dictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Dict selectDictById(Integer id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dict> getDictListByEntity(Dict dict) {
        return dictMapper.getDictListByEntity(dict);
    }

    @Override
    public PageInfo<Dict> getDictListByEntityPage(Dict dict, PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
        List<Dict> dictList = dictMapper.getDictListByEntity(dict);
        PageInfo<Dict> pageInfo = new PageInfo<Dict>(dictList);
        return pageInfo;
    }

    @Override
    public List<String> getAllDictType() {
        return dictMapper.getAllDictType();
    }
}
