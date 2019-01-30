package com.tz.cms.sysmgr;

import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/30 11:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class UserTest {

    @Autowired
    IUserService userService;

    @Test
    public void testQueryUserList(){
        User user = new User();
        List<User> userList = userService.queryUserList(user);
        System.out.println("userList="+userList);
    }
}
