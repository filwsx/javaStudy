package com.filwsx.service;

import org.springframework.stereotype.Component;

/**
 * @author filwsx
 * @create 2022-04-05 12:51
 */

@Component()
// @Component(value = "customerService")
public class CustomerService {
    public void add(){
        System.out.println("CustomerService add...");
    }
}
