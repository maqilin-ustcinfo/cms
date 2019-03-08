package com.tz.cms.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/26 15:56
 */
public class BigPerson extends Person{

    protected String other;

    @Override
    protected void finalize() throws Throwable {
    }

    public static void main(String[] args) {
        List<BigPerson> list = new ArrayList<>();
        //while (true){
            BigPerson bigPerson = new BigPerson();
            //list.add(bigPerson);
            BigPerson bigPerson2 = new BigPerson();
        System.out.println("bigPerson==bigPerson2:"+(bigPerson==bigPerson2));
        System.out.println("bigPerson==bigPerson2:"+(bigPerson));
        System.out.println("bigPerson==bigPerson2:"+(bigPerson2));
        //}
    }

}
