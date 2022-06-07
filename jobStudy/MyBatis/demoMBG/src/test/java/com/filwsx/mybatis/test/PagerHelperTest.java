package com.filwsx.mybatis.test;

import com.filwsx.mybatis.bean.Emp;
import com.filwsx.mybatis.mapper.EmpMapper;
import com.filwsx.mybatis.mapper.utils.SqlSessionUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        Page<Object> page = PageHelper.startPage(2, 4);
        List<Emp> list = mapper.selectByExample(null);
        list.forEach(emp -> System.out.println(emp));
        System.out.println(page);
        PageInfo<Emp> pageInfo = new PageInfo<>(list,3);
        System.out.println(pageInfo);
    }
}
