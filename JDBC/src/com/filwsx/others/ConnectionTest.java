package com.filwsx.others;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author filwsx
 * @date 2022-03-06 12:25
 */
public class ConnectionTest {

    private final String user = "root";
    private final String password = "183983";

    // jdbc:mysql:协议
    // localhost:ip地址
    // 3306：默认mysql的端口号
    // test:test数据库
    private final String url = "jdbc:mysql://localhost:3306/test";

    /* 方式五(final版)：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
     * 好处
     * 1.实现了数据与代码的分离。实现了解耦
     * 2.如果需要修改配置文件信息，可以避免程序重新打包。
     */
    @Test
    public void getConnection5() throws Exception{
        //1.读取配置文件中的4个基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

    // 方式四：可只加载驱动，不用显示注册驱动。
    @Test
    public void testConnection4() throws Exception {
        // 加载Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //相较于方式三，可以省略了注册驱动
        //因为在mysql的Driver实现类中有static

        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    // 方式三：使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {
        // 获取Driver实现类的对象
        Class cla = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) cla.newInstance();

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    // 方式二：对方式一的改进，增加可移植性
    @Test
    public void testConnection2() throws Exception{
        // 1.获取Driver实现类对象：使用反射，这样不在代码里直接引用第三方库
        Class cla = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) cla.newInstance();

        // 2.提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", user);
        info.setProperty("password", password);

        // 3.获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    // 方式一：
    @Test
    public void testConnection1() throws SQLException{
        Driver driver = new com.mysql.cj.jdbc.Driver();

        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", user);
        info.setProperty("password", password);

        Connection con = driver.connect(url,info);
        System.out.println(con);
    }
}
