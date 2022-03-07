package com.filwsx.preparedstatement;

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
 * @date 2022-03-07 19:40
 */
public class OrderForQuery {

    /*
     * 针对于表的字段名与类的属性名不相同的情况：
     * 1. 必须声明sql时，使用类的属性名来命名字段的别名
     * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
     *    获取列的别名。
     *  说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
     *
     *
     */
    @Test
    public void testOrderForQuery(){
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order = queryForOrder(sql,1);
        System.out.println(order);
    }

    public Order queryForOrder(String sql, Object...args){
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
            if(rs.next()){
                Order ord = new Order();
                for (int i = 0; i < columnCount; i++) {
                    //以下两句没能自己写出
                    Object value = rs.getObject(i+1);
                    String columnName = rsmd.getColumnLabel(i+1);
                    Field field = Order.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(ord,value);
                }
                return ord;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResoures(con,ps,rs);
        }
        return null;
    }
}
