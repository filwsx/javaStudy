package com.filwsx.test;

import com.filwsx.service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @create 2022-04-05 12:51
 */
public class BeanAnnotationTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/beanAnnotation.xml");
        CustomerService customerService = context.getBean("customerService",CustomerService.class);
        System.out.println(customerService);
        customerService.add();
    }

}
