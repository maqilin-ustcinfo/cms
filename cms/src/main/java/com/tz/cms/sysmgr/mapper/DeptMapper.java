package com.tz.cms.sysmgr.mapper;

import com.tz.cms.sysmgr.entity.Dept;
import java.util.List;

public interface DeptMapper {
    /**
     * 查询部门By id
     * @param id
     * @return
     */
    Dept selectByPrimaryKey(Long id);


    /**
     * 根据parentId得到子部门
     * @param parentId
     * @return
     */
    List<Dept> getChildNodeByParentId(Long parentId);

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> getAllDeptList();

    /**
     * 统计一个节点下的子节点数量
     * @param parentId
     * @return
     */
    Integer getCountByParentId(Long parentId);

    /**
     * 增加部门
     * @param record
     * @return
     */
    Integer insertSelective(Dept record);

    /**
     * 删除部门
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Long id);


    /**
     * 更新部门
     * @param record
     * @return
     */
    Integer updateByPrimaryKeySelective(Dept record);
}