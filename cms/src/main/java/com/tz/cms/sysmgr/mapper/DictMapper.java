package com.tz.cms.sysmgr.mapper;

import com.tz.cms.sysmgr.entity.Dict;

import java.util.List;

public interface DictMapper {

    /**
     * 增加
     * @param record
     * @return
     */
    int insertSelective(Dict record);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Dict record);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Dict selectByPrimaryKey(Integer id);

    /**
     * 根据条件查询
     * @param dict
     * @return
     */
    List<Dict> getDictListByEntity(Dict dict);

    /**
     * 根据条件查询
     * @return
     */
    List<String> getAllDictType();



}