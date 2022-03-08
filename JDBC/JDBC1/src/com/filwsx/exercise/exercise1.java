package com.filwsx.exercise;

import com.filwsx.utils.JDBCutils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author filwsx
 * @date 2022-03-08 11:29
 */
public class exercise1 {

    @Test
    public void testInsert(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name = scanner.next();
        System.out.print("请输入邮箱：");
        String email = scanner.next();
        System.out.print("请输入生日：");
        String birthday = scanner.next();//'1992-09-08'

        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        boolean insertCount = insert(sql,name,email,birthday);
        if(insertCount){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    //这部分自己写的，so Easy
    public boolean insert(String sql,Object ... args){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCutils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResoures(con,ps);
        }
        return false;
    }
}
