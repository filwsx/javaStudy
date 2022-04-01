package com.filwsx.test;

import com.filwsx.bean.Emp;
import com.filwsx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @create 2022-04-01 18:13
 */
public class BeanByXmlTest2 {
    // 外部bean测试
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanXml2.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }

    // 内部bean测试
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanXml3.xml");
        Emp emp = context.getBean("emp",Emp.class);
        System.out.println(emp);
    }
}
