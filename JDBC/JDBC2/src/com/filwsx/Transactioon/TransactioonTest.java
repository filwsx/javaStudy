package com.filwsx.Transactioon;

import com.filwsx.utils.JDBCutils;

import java.sql.Connection;

/**
 * @author filwsx
 * @date 2022-03-08 16:00
 */
public class TransactioonTest {
    public void test1(){
        Connection con =null;
        try {
            con = JDBCutils.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
