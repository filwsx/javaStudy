package com.filwsx.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author filwsx
 * @create 2022-04-05 13:42
 */
@Component
@Service(value = "customerDAO1")
public class CustomerDAO implements Customer{
    // @Value：注入普通类型属性
    @Value(value = "张三")
    private String name;

    @Override
    public void add() {
        System.out.println("CustomerDAO add.....");
        System.out.println(name);
    }
}
