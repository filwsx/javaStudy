package com.filwsx.preparedstatement;

import com.filwsx.utils.JDBCutils;
import org.junit.Test;

import java.sql.*;

/**
 * @author filwsx
 * @date 2022-03-07 15:42
 */
public class CustomerForQuery {

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
            try {
                if (con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
