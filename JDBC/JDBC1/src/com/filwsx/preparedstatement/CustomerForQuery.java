package com.filwsx.preparedstatement;

import com.filwsx.bean.Customer;
import com.filwsx.utils.JDBCutils;
import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;

/**
 * @author filwsx
 * @date 2022-03-07 15:42
 */
public class CustomerForQuery {

    @Test
    public void testQueryForCustomers(){
        String sql = "select id,name,birth,email from customers where id = ?";
        Customer customer = queryForCustomers(sql, 13);
        System.out.println(customer);

        sql = "select name,email from customers where name = ?";
        Customer customer1 = queryForCustomers(sql,"周杰伦");
        System.out.println(customer1);
    }

    public Customer queryForCustomers(String sql,Object...args){
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
                Customer cus = new Customer();
                for (int i = 0; i < columnCount; i++) {
                    Object value = rs.getObject(i+1);
                    String columnName = rsmd.getColumnName(i+1);
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(cus,value);
                    //尝试用set方法
//                    String methodName = "set"+ StringUtils.capitalize(columnName);
//                    //由于数组参数未知，不好找，放弃
//                    Method method = Customer.class.getMethod(methodName,Object.class);
//                    method.invoke(cus,value);
                }
                return cus;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResoures(con,ps,rs);
        }
        return null;
    }

    @Test
    public void reflectTest(){
        Method [] method = Customer.class.getMethods();
        for(Method m: method){
            System.out.println(m);
        }
    }
    @Test
    public void testQuery1() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCutils.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, 1);
            rs = ps.executeQuery();
            if (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                Date birth = rs.getDate(4);
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResoures(con,ps,rs);
        }
    }
}
