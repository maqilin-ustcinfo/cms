package com.tz.cms.test;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/21 20:42
 */
public class TestInterfaceImpl implements TestInterface {
    @Override
    public int say3() {
        return 0;
    }

    public static void main(String[] args) {

        // 值在-128~127 都是取缓存中的同一个对象，否则是不是同一个对象。
        Integer a = -129;
        Integer b = -129;
        int c = a;
        System.out.println("是同一个对象？"+(a == b));// false
        System.out.println("对象相等吗？"+ a.equals(b));// true
    }
}
