package com.filwsx.DAO;

import com.filwsx.JDBCutils.JDBCutils;
import com.filwsx.bean.Fruit;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author filwsx
 * @date 2022-03-13 18:06
 */
public class fruitDAOTest {

    @Test
    public void insertTest(){
        fruitDAOimpl fdi = new fruitDAOimpl();
        Connection con = null;
        try {
            con = JDBCutils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Fruit fruit = new Fruit(1,"apple",8999,999,"iphone");
        fdi.insert(con,fruit);
    }

    @Test
    public void deleteByIdTest(){
        fruitDAOimpl fdi = new fruitDAOimpl();
        Connection con = null;
        try {
            con = JDBCutils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Fruit fruit = new Fruit(1,"apple",8999,999,"iphone");
        fdi.deleteById(con,1);
    }

    @Test
    public void updateTest(){

    }

    @Test
    public void getItemByIdTest(){
    }

    @Test
    public void getAllTest(){
    }

    @Test
    public void testGetCountTest(){

    }
}