package com.tz.cms.test.dao.impl;

import com.tz.cms.sysmgr.entity.Area;
import com.tz.cms.test.dao.IAreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/24 10:32
 */
@Repository
public class AreaDao implements IAreaDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String,Object>> getAreaAllList() {
        String sql = "select area_id as areaId,area_name areaName," +
                "parent_id parentId,sort,area_code areaCode,update_by updateBy,update_time updateTime,remarks " +
                "from pm_sys_area";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public Map<String,Object> getAreaById(Integer areaId) {
        String sql = "select area_id,area_name,parent_id,sort,area_code,update_by,update_time,remarks " +
                "from pm_sys_area where area_id=?";
        return jdbcTemplate.queryForList(sql,areaId).get(0);
    }

    @Override
    public int uptAreaById(String remarks,Integer areaId) {
        String sql = "update pm_sys_area set remarks = ? " +
                "where area_id=?";
        // 增删改都是update
        return jdbcTemplate.update(sql,remarks,areaId);
    }
}
