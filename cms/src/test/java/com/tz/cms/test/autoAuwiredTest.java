package com.tz.cms.test;

import com.tz.cms.test.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author maqilin
 * @description:自动装配测试
 * @date 2019/1/24 9:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springtest/bean-autowired.xml"})
public class autoAuwiredTest {

    @Autowired
    Person person;

    @Test
    public void getBean(){
        System.out.println("person=========="+person);
    }

}
