package com.tz.cms.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author maqilin
 * @description:
 * @date 2019/1/24 9:43
 */
public class Car implements Serializable {

    private String name;

    private BigDecimal pricie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPricie() {
        return pricie;
    }

    public void setPricie(BigDecimal pricie) {
        this.pricie = pricie;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", pricie=" + pricie +
                '}';
    }
}
