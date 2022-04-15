package com.filwsx.DAO;

import com.filwsx.bean.ItBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author filwsx
 * @create 2022-04-14 9:26
 */

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(ItBook itBook) {
        String sql = "insert into itBook values(?,?)";
        Object [] args = {itBook.getId(),itBook.getName()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }
}
