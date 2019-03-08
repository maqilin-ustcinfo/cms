package com.tz.cms.test;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/26 15:48
 */
public class Hourse {

    private String id;

    static {
        System.out.println("静态代码块");
    }

    public Hourse(String id) {
        System.out.println("初始化Hourse");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public static void main(String[] args) {
        Hourse hourse = new Hourse("1");
    }
}
