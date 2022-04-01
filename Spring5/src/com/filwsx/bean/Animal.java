package com.filwsx.bean;

/**
 * @author filwsx
 * @create 2022-04-01 17:30
 */
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal含参构造器执行了");
    }
}
