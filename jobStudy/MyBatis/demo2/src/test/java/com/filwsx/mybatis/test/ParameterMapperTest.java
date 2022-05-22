package com.filwsx.mybatis.test;

import com.filwsx.mybatis.mapper.ParameterMapper;
import com.filwsx.mybatis.pojo.User;
import com.filwsx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author filwsx
 * @create 2022-05-22 21:18
 */
public class ParameterMapperTest {
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("张三");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("张三", "456");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "李四");
        map.put("password", "789");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(3, "罗翔", "23333", 45, "男", "luoxiang@huayilaw"));
        System.out.println(result);
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("罗翔", "23333");
        System.out.println(user);
    }

}
