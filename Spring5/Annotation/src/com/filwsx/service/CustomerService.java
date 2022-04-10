package com.filwsx.service;

import com.filwsx.bean.Customer;
import com.filwsx.bean.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author filwsx
 * @create 2022-04-05 12:51
 */

@Component    //括号里不写东西，程序就一直在运行也不报错和输出，不知道为什么。因为之前指定的base-package没有CustomerService！
//@Component(value = "customerService")
public class CustomerService {

    // @Autowired：根据类型进行注入
    @Autowired
    // @Qualifier：根据名称进行注入
    // @Qualifier(value = "customerDAO2")
    // @Resource：可以根据类型注入，可以根据名称注入
    @Resource(name = "customerDAO1")
    private Customer customerDAO;

    public void add(){
        System.out.println("CustomerService add...");
        customerDAO.add();
    }
}
