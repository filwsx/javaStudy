package com.filwsx.mybatis.test;

import com.filwsx.mybatis.mapper.CacheMapper;
import com.filwsx.mybatis.pojo.Emp;
import com.filwsx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author filwsx
 * @create 2022-06-07 8:55
 */
public class CacheMapperTest {
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper.getEmpById(3);
        System.out.println(emp1);
        Emp emp2 = cacheMapper.getEmpById(3);
        System.out.println(emp2);
    }

    @Test
    public void testCacheLevel2() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        System.out.println(cacheMapper1.getEmpById(1));
        sqlSession1.close();
        System.out.println(cacheMapper2.getEmpById(1));
        sqlSession2.close();
    }

}
