package com.tz.cms.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/20 15:15
 */
public class Person {

    protected String name;

    protected Integer age;

    protected String address;



    public Person() {
    }

    private Person(String name, Integer age, String address) {
        System.out.println("初始化Person");
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        /*ExecutorService threedPool = Executors.newFixedThreadPool(10);
        try {
            for(int i=0;i<10;i++){
                MyThread task = new MyThread();
                Future<String> future = threedPool.submit(task);
                System.out.println(future.get());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            threedPool.shutdown();
        }*/
        // 值在-128~127 都是取缓存中的同一个对象，否则是不是同一个对象。
        Integer a = -129;
        Integer b = -129;
       // int c = a;
        System.out.println("是同一个对象？"+(a == b));
        System.out.println("对象相等吗？"+ a.equals(b));// true

        Person p = new Person();
    }
}
