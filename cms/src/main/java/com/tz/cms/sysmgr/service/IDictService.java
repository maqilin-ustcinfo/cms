package com.tz.cms.sysmgr.service;

import com.github.pagehelper.PageInfo;
import com.tz.cms.framework.dto.PageParam;
import com.tz.cms.sysmgr.entity.Dict;

import java.util.List;

/**
 * @author maqilin
 * @description: 字典接口
 * @date 2019/1/31 10:21
 */
public interface IDictService {
    /**
     * 增加
     * @param record
     * @return
     */
    int addDict(Dict record);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteDict(Integer id);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateDict(Dict record);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Dict selectDictById(Integer id);

    /**
     * 根据条件查询
     * @param dict
     * @return
     */
    List<Dict> getDictListByEntity(Dict dict);

    /**
     * 根据条件查询
     * @param dict
     * @return
     */
    PageInfo<Dict> getDictListByEntityPage(Dict dict, PageParam pageParam);

    /**
     * 根据条件查询
     * @return
     */
    List<String> getAllDictType();
}
