package com.filwsx.utils;

import com.filwsx.preparedstatement.PreparedStatementTest;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**操作数据库的工具类
 * @author filwsx
 * @date 2022-03-07 15:06
 */
public class JDBCutils {
    public static Connection getConnection() throws Exception{
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(is);

        String user = pro.getProperty("user");
        String pwd = pro.getProperty("password");
        String driverClass = pro.getProperty("driverClass");
        String url = pro.getProperty("url");

        Class.forName(driverClass);

        Connection con = DriverManager.getConnection(url,user,pwd);
        return con;
    }

    public static void closeResoures(Connection con,Statement ps){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
