package com.filwsx.others;

import com.filwsx.utils.JDBCutils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author filwsx
 * @date 2022-03-08 14:51
 */
public class BlobTest {
    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInsert() throws Exception{
        Connection con = JDBCutils.getConnection();
        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setObject(1,"filwsx");
        ps.setObject(2, "filwsx@qq.com");
        ps.setObject(3,"1987-09-08");
        FileInputStream is = new FileInputStream(new File("38.jpg"));
        ps.setBlob(4, is);

        ps.execute();

        JDBCutils.closeResoures(con, ps);

    }
}
