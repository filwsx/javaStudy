package com.filwsx.beanManager;

import com.filwsx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @create 2022-04-01 18:13
 */
public class BeanByXmlTest2 {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanXml2.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }
}
