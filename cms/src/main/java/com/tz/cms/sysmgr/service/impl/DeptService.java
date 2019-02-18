package com.tz.cms.sysmgr.service.impl;

import com.tz.cms.framework.util.UserUtils;
import com.tz.cms.sysmgr.entity.Dept;
import com.tz.cms.sysmgr.entity.RoleToDept;
import com.tz.cms.sysmgr.mapper.DeptMapper;
import com.tz.cms.sysmgr.mapper.RoleMapper;
import com.tz.cms.sysmgr.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/11 11:05
 */
@Service
public class DeptService implements IDeptService {

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Dept selectByPrimaryKey(Long id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> getChildNodeByParentId(Long parentId) {
        return deptMapper.getChildNodeByParentId(parentId);
    }

    @Override
    public List<Dept> getAllDeptList() {
        return deptMapper.getAllDeptList();
    }

    @Override
    public Integer getCountByParentId(Long parentId) {
        return deptMapper.getCountByParentId(parentId);
    }

    @Override
    @Transactional
    public Integer insertSelective(Dept record) {
        record.setUpdateBy(UserUtils.getCurrrentUserId()+"");
        record.setUpdateDate(new Date());
        int i = deptMapper.insertSelective(record);
        RoleToDept roleToDept = new RoleToDept();
        roleToDept.setDeptId(record.getId());
        roleToDept.setRoleId(1L);
        roleMapper.insertRoleToDept(roleToDept);
        return i;
    }

    @Override
    @Transactional
    public Integer deleteByPrimaryKey(Long id) {
        roleMapper.deleteRoleToDeptByDeptId(id);
        return deptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(Dept record) {
        record.setUpdateBy(UserUtils.getCurrrentUserId().toString());
        record.setUpdateDate(new Date());
        return deptMapper.updateByPrimaryKeySelective(record);
    }
}
