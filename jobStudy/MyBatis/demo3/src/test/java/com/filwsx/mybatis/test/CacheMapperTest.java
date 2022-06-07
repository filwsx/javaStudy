package com.filwsx.mybatis.test;

import com.filwsx.mybatis.mapper.CacheMapper;
import com.filwsx.mybatis.pojo.Emp;
import com.filwsx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}
