package com.filwsx.preparedstatement;

import com.filwsx.utils.JDBCutils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author filwsx
 * @date 2022-03-06 18:00;
 */
public class PreparedStatementUpdate {

    @Test
    public void tsetUpdate(){
        String sql = "delete from customers where id = ?";
        update(sql,10);
    }

    //通用增删改操作
    public void update(String sql,Object ...args){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCutils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResoures(con,ps);
        }
    }
    @Test
    public void testUpdate2() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCutils.getConnection();
            String sql = "update customers set name = ? where id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,"马斯克");
            ps.setInt(2,18);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResoures(con,ps);
        }
    }

    @Test
    public void testUpdate() throws  Exception{
        Connection con = JDBCutils.getConnection();
        String sql = "update customers set name = ? where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,"马斯克");
        ps.setInt(2,18);
        ps.execute();
        JDBCutils.closeResoures(con,ps);
    }
    @Test
    public void toInsert() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        //无法使用Java8新特性，try()
        try{
            Properties pro = new Properties();
            // 这么写还得关掉Stream，麻烦！
            // FileInputStream  fis = new FileInputStream("jdbc.properties");
            InputStream is = PreparedStatementUpdate.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // String类不行
            // InputStream is = String.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(is);

            String user = pro.getProperty("user");
            String pwd = pro.getProperty("password");
            String driverClass = pro.getProperty("driverClass");
            String url = pro.getProperty("url");

            Class.forName(driverClass);

            con = DriverManager.getConnection(url,user,pwd);

            String sql = "insert into customers(name,email,birth)values(?,?,?)";

            ps = con.prepareStatement(sql);
            ps.setString(1,"filwsx");
            ps.setString(2,"filwsx@gmail.com");
            // 字符串不行
            // ps.setString(3,"1987-01-13");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1987-01-13");
            Date sqlDate = new Date(date.getTime());
            ps.setDate(3, sqlDate);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
}
