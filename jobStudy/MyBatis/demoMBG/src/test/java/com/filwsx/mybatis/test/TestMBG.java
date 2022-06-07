package com.filwsx.mybatis.test;

import com.filwsx.mybatis.bean.Emp;
import com.filwsx.mybatis.bean.EmpExample;
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

        // 查询所有数据
        List<Emp> empList1 = empMapper.selectByExample(null);
        empList1.forEach(emp -> System.out.println(emp));

        // 查询符合条件的数据
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("张三");
        List<Emp> empList2 = empMapper.selectByExample(empExample);
        empList2.forEach(emp -> System.out.println(emp));
    }
}
