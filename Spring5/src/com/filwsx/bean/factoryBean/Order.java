package com.filwsx.bean.factoryBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author filwsx
 * @create 2022-04-02 12:50
 */
public class Order{
    private String str;
    public Order() {
        System.out.println("空参构造器被调用了");
    }

    public void setStr(String str) {
        this.str = str;
        System.out.println("set被调用了");
    }

    // 需要配置
    public void initMethod(){
        System.out.println("initMethod被调用了");
    }

    // 需要配置
    public void destroyBean(){
        System.out.println("destroyBean被调用了");
    }
}
