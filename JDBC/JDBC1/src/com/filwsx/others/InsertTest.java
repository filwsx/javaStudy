package com.filwsx.others;

import com.filwsx.utils.JDBCutils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 使用PreparedStatement如何实现更高效的批量插入
 *
 * @author filwsx
 * @date 2022-03-08 15:08
 */
public class InsertTest {

    //批量插入的方式四：设置连接不允许自动提交数据
    @Test
    public void insertTest3(){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();

            con = JDBCutils.getConnection();
            con.setAutoCommit(false);

            String sql = "insert into goods(name)values(?)";
            ps = con.prepareStatement(sql);
            for (int i = 1; i < 1000000; i++) {
                ps.setObject(1,"name_" + i);
                ps.addBatch();
                if(i % 500 == 0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            con.commit();
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));//20000:83065
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeResoures(con,ps);
        }
    }

    /*
     * 批量插入的方式三：
     * 1.addBatch()、executeBatch()、clearBatch()
     * 2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
     * 		 ?rewriteBatchedStatements=true 写在配置文件的url后面
     * 3.使用更新的mysql 驱动：mysql-connector-java-5.1.37-bin.jar
     */
    @Test
    public void insertTest2(){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();

            con = JDBCutils.getConnection();
            String sql = "insert into goods(name)values(?)";
            ps = con.prepareStatement(sql);
            for (int i = 0; i < 1000000; i++) {
                ps.setObject(1,"name_" + i);
                ps.addBatch();
                if(i % 500 == 0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));//20000:83065
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeResoures(con,ps);
        }
    }

    @Test
    public void insertTest1(){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();

            con = JDBCutils.getConnection();
            String sql = "insert into goods(name)values(?)";
            ps = con.prepareStatement(sql);
            for (int i = 0; i < 20000; i++) {
                ps.setObject(1,"name_" + i);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));//20000:83065
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeResoures(con,ps);
        }
    }
}
