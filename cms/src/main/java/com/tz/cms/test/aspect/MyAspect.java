package com.tz.cms.test.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author maqilin
 * @description: 切面织入某些方法
 * @date 2019/1/24 15:00
 */
@Aspect
public class MyAspect {

    @AfterReturning(value = "execution(public * com.tz.cms.test.service.impl.AreaServiceTest.getAreaAllList())",returning = "result")
    public void afterReturning(Object result){
        System.out.println("后置通知result=="+result);
    }

    @AfterThrowing(value = "execution(public * com.tz.cms.test.service.impl.AreaServiceTest.getAreaAllList())",throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("异常通知="+e.getMessage());
    }


}
