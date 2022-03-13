package com.filwsx.DAO;

import com.filwsx.JDBCutils.JDBCutils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author filwsx
 * @date 2022-03-13 17:26
 */
public class baseDAO {

    // 考虑上事务的，通用的增删改操作
    public static int update(Connection con,String sql,Object ... args){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResoures(null,ps);
        }
        return 0;
    }

    // 虑上事务d的通用的查询操作，用于返回数据表中的多条记录构成的集合
    public static <T> List<T> getList(Connection con,Class<T> cla , String sql, Object ...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<T> list = new ArrayList<T>();
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()){
                T t = cla.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = rs.getObject(i+1);
                    String columnName = rsmd.getColumnLabel(i+1);
                    Field field = cla.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResoures(null,ps,rs);
        }
        return list;
    }

    //用于查询特殊值的通用的方法
    public <E> E getValue(Connection con,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCutils.closeResoures(null, ps, rs);
        }
        return null;
    }
}
