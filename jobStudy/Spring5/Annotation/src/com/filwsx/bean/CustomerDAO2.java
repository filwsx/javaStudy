package com.filwsx.bean;

import org.springframework.stereotype.Service;

/**
 * @author filwsx
 * @create 2022-04-05 13:46
 */

@Service(value = "customerDAO2")
public class CustomerDAO2 implements Customer{
    @Override
    public void add() {
        System.out.println("CustomerDAO2 add.....");
    }
}
