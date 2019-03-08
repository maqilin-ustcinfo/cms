package com.tz.cms.test;

public interface TestInterface {

    default void say(){
        System.out.println("说=");
    }

    static void say2(){
        System.out.println("说2=");
    }

    int say3();

}
