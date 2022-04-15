package com.filwsx.test;

import com.filwsx.bean.ItBook;
import com.filwsx.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author filwsx
 * @create 2022-04-14 9:51
 */
public class JDBCTest {
    @Test
    public void testItBook(){
        ItBook itBook = new ItBook(1984,"Watching you!");
        ApplicationContext context = new ClassPathXmlApplicationContext("com/filwsx/jdbc.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        bookService.add(itBook);
    }
}
