package com.tz.cms.test;

import com.tz.cms.test.service.IAreaServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author maqilin
 * @description: 测试利用jdk动态代理实现AOP
 * @date 2019/1/24 14:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class MyInvokeHandlerTest {

    @Autowired
    IAreaServiceTest areaServiceTest;

    @Test
    public void testProxy(){
        IAreaServiceTest proxy = (IAreaServiceTest) Proxy.newProxyInstance(
                areaServiceTest.getClass().getClassLoader(),
                areaServiceTest.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("添加权限验证");
                        Object object = method.invoke(areaServiceTest,args);
                        System.out.println("添加日志记录");
                        return object;
                    }
                }
        );
        // 代理类执行
        System.out.println(proxy.getAreaAllList());
    }

    @Test
    public void testAspect(){
        areaServiceTest.getAreaAllList();
    }
}
