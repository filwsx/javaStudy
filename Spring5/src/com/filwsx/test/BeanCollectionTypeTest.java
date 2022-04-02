package com.filwsx.test;

import com.filwsx.bean.Course;
import com.filwsx.bean.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @create 2022-04-01 19:03
 */
public class BeanCollectionTypeTest {
    @Test
    public void testCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanXmlCollectionType.xml");
        Stu stu = context.getBean("stu",Stu.class);
        System.out.println(stu);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanXmlCollectionType2.xml");
        Course course = context.getBean("course",Course.class);
        System.out.println(course);
    }
}
