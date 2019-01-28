package com.tz.cms.sysmgr.mapper;

import com.tz.cms.sysmgr.dto.UserDto;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/28 8:56
 */
public interface UserMapper {

    /**
     * 通过userId获取得到user及其部门信息
     * @param userId
     * @return
     */
    UserDto getUserDtoById(Integer userId);

    /**
     * 通过userId获取得到user及其角色
     * @param userId
     * @return
     */
    UserDto getUserDtoById2(Integer userId);

}
