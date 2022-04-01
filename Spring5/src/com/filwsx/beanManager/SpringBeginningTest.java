package com.filwsx.beanManager;

import com.filwsx.bean.Animal;
import com.filwsx.bean.Book;
import com.filwsx.bean.Rectangle;
import com.filwsx.bean.SpringBeginning;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @date 2022-02-22 21:13
 */
public class SpringBeginningTest {



    @Test
    public void NewTest(){

        // 1.加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanTest.xml");

        // 2.获取配置创建的对象
        SpringBeginning ss = context.getBean("springBeginning", SpringBeginning.class);
        System.out.println(ss);
        ss.show();
    }

    @Test
    public void beanByXmlTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanTest.xml");

        Book book1 = context.getBean("book1",Book.class);
        System.out.println(book1);
        Book book2 = context.getBean("book2",Book.class);
        System.out.println(book2);
    }

    @Test
    public void testOrder(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/BeanTest.xml");

//        Animal animal = context.getBean("animal",Animal.class);
//        System.out.println(animal);
//
//        Rectangle rectangle = context.getBean("rectangle",Rectangle.class);
//        System.out.println(rectangle);

        // 结论：不论是采用哪种注入方式，一旦有一个ClassPathXmlApplicationContext就会初始化所有对象，按照配置顺序 20220401 1741。
    }
}
