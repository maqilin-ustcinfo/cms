package com.tz.cms.test.entity;

import java.io.Serializable;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/24 9:46
 */
public class Person implements Serializable {

    private String name;

    private Adress adress;

    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", adress=" + adress +
                ", car=" + car +
                '}';
    }
}
