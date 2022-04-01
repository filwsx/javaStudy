package com.filwsx.beanManager;

import com.filwsx.bean.Book;
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
        Book book2 = context.getBean("book2",Book.class);
        System.out.println(book1);
        System.out.println(book2);
    }
}
