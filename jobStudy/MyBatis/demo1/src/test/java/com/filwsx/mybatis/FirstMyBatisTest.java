package com.filwsx.mybatis;

import com.filwsx.mybatis.mapper.UserMapper;
import com.filwsx.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author filwsx
 * @create 2022-05-21 14:46
 */
public class FirstMyBatisTest {

    @Test
    public void testMyBatis() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.insertUser();

        // sqlSession.commit();

        System.out.println("res:"+ res);
    }

    @Test
    public void testCRUD() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // mapper.updateUser();

//        User user = mapper.getUserById();
//        System.out.println(user);
        for (User user : mapper.getAllUser()) {
            System.out.println(user);
        }

    }
}
