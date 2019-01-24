package com.tz.cms.test.entity;

import java.io.Serializable;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/24 9:45
 */
public class Adress implements Serializable {

    private String city;

    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
