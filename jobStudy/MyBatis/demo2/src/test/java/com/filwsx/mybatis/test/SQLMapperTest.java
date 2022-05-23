package com.filwsx.mybatis.test;

import com.filwsx.mybatis.mapper.SQLMapper;
import com.filwsx.mybatis.pojo.User;
import com.filwsx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author filwsx
 * @create 2022-05-23 11:59
 */
public class SQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("张");
        System.out.println(list);
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("1,2,3");
        System.out.println(result);
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "王五", "123", 23, "男", "123@163.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    public void testJDBC() throws Exception {
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        PreparedStatement ps = connection.prepareStatement("insert", Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        ResultSet resultSet = ps.getGeneratedKeys();
    }
}
