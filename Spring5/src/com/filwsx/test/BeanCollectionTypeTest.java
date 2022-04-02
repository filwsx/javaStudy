package com.filwsx.test;

import com.filwsx.bean.collection.Cou;
import com.filwsx.bean.collection.Stu;
import com.filwsx.bean.factoryBean.Order;
import com.filwsx.bean.school.Student;
import com.filwsx.bean.school.Teacher;
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

    @Test
    // 测试单实例与多实例
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanXmlScope.xml");
        Student student1 = context.getBean("student", Student.class);
        Student student2 = context.getBean("student", Student.class);
        Teacher teacher1 = context.getBean("teacher", Teacher.class);
        Teacher teacher2 = context.getBean("teacher", Teacher.class);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(teacher1);
        System.out.println(teacher2);
    }

    @Test
    // 测试Bean的生命周期，含后置处理器
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanXmlProcess.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("已经获取对象:" + order);
        ((ClassPathXmlApplicationContext)context).close();
    }
}
