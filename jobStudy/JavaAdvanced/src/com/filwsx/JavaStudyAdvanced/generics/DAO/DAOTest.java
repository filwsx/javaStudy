package com.filwsx.JavaStudyAdvanced.generics.DAO;

import org.junit.Test;

import java.util.List;

/**
 * @author filwsx
 * @date 2022-02-15 19:50
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);


        StudentDAO dao2 = new StudentDAO();
        Student student = dao2.getIndex(1);
    }
}
