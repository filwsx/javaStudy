package com.filwsx.others;

import com.filwsx.bean.Customer;
import com.filwsx.utils.JDBCutils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @author filwsx
 * @date 2022-03-08 14:51
 */
public class BlobTest {

    //查询数据表customers中Blob类型的字段
    @Test
    public void testQuery(){
        Connection conn = null;
        PreparedStatement ps = null;
        InputStream is = null;
        FileOutputStream fos = null;
        ResultSet rs = null;
        try {
            conn = JDBCutils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 16);
            rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer cust = new Customer(id, name, email, birth);
                System.out.println(cust);

                //将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("zhuyin.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCutils.closeResoures(conn, ps, rs);
        }
    }

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
