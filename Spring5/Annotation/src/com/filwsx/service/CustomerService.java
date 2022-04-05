package com.filwsx.service;

import org.springframework.stereotype.Component;

/**
 * @author filwsx
 * @create 2022-04-05 12:51
 */

//@Component() 括号里不写东西，程序就一直在运行也不报错和输出，不知道为什么
@Component(value = "customerService")
public class CustomerService {
    public void add(){
        System.out.println("CustomerService add...");
    }
}
