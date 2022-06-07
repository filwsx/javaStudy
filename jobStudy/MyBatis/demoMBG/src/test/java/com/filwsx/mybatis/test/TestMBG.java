package com.filwsx.mybatis.test;

import com.filwsx.mybatis.bean.Emp;
import com.filwsx.mybatis.mapper.EmpMapper;
import com.filwsx.mybatis.mapper.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author filwsx
 * @create 2022-06-07 11:32
 */
public class TestMBG {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.selectByExample(null);
        empList.forEach(emp -> System.out.println(emp));
    }
}
