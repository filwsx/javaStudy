package com.filwsx.beanManager;

import com.filwsx.bean.Book;
import com.filwsx.bean.Rectangle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @create 2022-04-01 17:54
 */
public class BeanByXmlTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanXml1.xml");

    // 两种不同方式的注入 set 和 构造器
    @Test
    public void test1(){

        Book book1 = context.getBean("book1",Book.class);
        System.out.println(book1);
        Book book2 = context.getBean("book2",Book.class);
        System.out.println(book2);
    }

    // 测试执行顺序
    @Test
    public void testOrder(){

        // 仅有含参构造器
//        Animal animal = context.getBean("animal",Animal.class);
//        System.out.println(animal);

        // 仅有set方法
//        Rectangle rectangle = context.getBean("rectangle",Rectangle.class);
//        System.out.println(rectangle);

        // 结论：不论是采用哪种注入方式，一旦有一个ClassPathXmlApplicationContext就会初始化所有对象，按照配置顺序 20220401 1741。
    }

    // 空值注入
    @Test
    public void test4(){
        Rectangle rectangle = context.getBean("null",Rectangle.class);
        System.out.println(rectangle);
    }

    // 特殊字符注入
    @Test
    public void test5(){
        Rectangle rectangle = context.getBean("test5",Rectangle.class);
        System.out.println(rectangle);
    }
}
