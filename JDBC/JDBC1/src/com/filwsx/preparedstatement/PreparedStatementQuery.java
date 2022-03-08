package com.filwsx.preparedstatement;

import com.filwsx.bean.Customer;
import com.filwsx.bean.Order;
import com.filwsx.utils.JDBCutils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author filwsx
 * @date 2022-03-08 10:56
 */
public class PreparedStatementQuery {

    @Test
    public void testGetInstance(){
        String sql = "select id,name,email from customers where id = ?";
        Customer customer = getInstance(Customer.class,sql,12);
        System.out.println(customer);

        String sql1 = "select order_id orderId,order_name orderName from `order` where order_id = ?";
        Order order = getInstance(Order.class, sql1, 1);
        System.out.println(order);
    }

    public <T> T getInstance(Class<T> cla , String sql, Object ...args){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCutils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()){
                T t = cla.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = rs.getObject(i+1);
                    String columnName = rsmd.getColumnLabel(i+1);
                    Field field = cla.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResoures(con,ps,rs);
        }
        return null;
    }
}
