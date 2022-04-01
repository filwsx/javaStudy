package com.filwsx.test;

import com.filwsx.bean.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @create 2022-04-01 19:03
 */
public class BeanCollectionType {
    @Test
    public void testCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanXmlCollectionType.xml");
        Stu stu = context.getBean("stu",Stu.class);
        System.out.println(stu);
    }
}
