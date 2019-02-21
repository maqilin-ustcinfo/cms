package com.tz.cms.test;

import java.util.concurrent.Callable;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/20 16:04
 */
public class MyThread implements Callable {

    @Override
    public Object call() throws Exception {

        System.out.println(Thread.currentThread().getName()+"执行");

        return "ok";
    }
}
