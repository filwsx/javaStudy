package com.filwsx.SpringStart;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @date 2022-02-22 21:13
 */
public class NewClassTest {
    @Test
    public void NewTest(){
        // 1.加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/SpringStart/BeanTest.xml");
        // 2.获取配置创建的对象
        SpringStart ss = context.getBean("SpringStart",SpringStart.class);
        System.out.println(ss);
        ss.show();
    }
}
