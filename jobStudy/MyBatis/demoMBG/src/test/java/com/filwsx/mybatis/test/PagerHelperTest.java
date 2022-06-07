package com.filwsx.mybatis.test;

import com.filwsx.mybatis.bean.Emp;
import com.filwsx.mybatis.mapper.EmpMapper;
import com.filwsx.mybatis.mapper.utils.SqlSessionUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author filwsx
 * @create 2022-06-07 11:55
 */
public class PagerHelperTest {

    @Test
    public void testPagerHelper(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        PageHelper.startPage(2, 4);
        List<Emp> list = mapper.selectByExample(null);
        list.forEach(emp -> System.out.println(emp));

    }
}
