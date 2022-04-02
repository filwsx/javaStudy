package com.filwsx.test;

import com.filwsx.bean.collection.Cou;
import com.filwsx.bean.collection.Stu;
import com.filwsx.bean.school.Student;
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
        Cou course = context.getBean("course", Cou.class);
        System.out.println(course);
    }

    @Test
    // 测试factoryBean
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/factoryBean1.xml");
        Student student = context.getBean("myBean", Student.class);
        System.out.println(student);
    }
}
