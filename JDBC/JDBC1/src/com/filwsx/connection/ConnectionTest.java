package com.filwsx.connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author filwsx
 * @date 2022-03-06 12:25
 */
public class ConnectionTest {

    // 方式一：
    @Test
    public void testConnection1() throws SQLException{
        Driver driver = new com.mysql.cj.jdbc.Driver();

        // jdbc:mysql:协议
        // localhost:ip地址
        // 3306：默认mysql的端口号
        // test:test数据库
        String url = "jdbc:mysql://localhost:3306/test";

        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "183983");

        Connection con = driver.connect(url,info);
        System.out.println(con);
    }

    // 方式二：对方式一的改进，增加可移植性
    @Test
    public void testConnection2() throws Exception{

    }
}
