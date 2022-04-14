package com.filwsx.service;

import com.filwsx.DAO.BookDao;
import com.filwsx.bean.ItBook;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author filwsx
 * @create 2022-04-14 9:24
 */
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void add(ItBook itBook){
        bookDao.add(itBook);
    }
}
