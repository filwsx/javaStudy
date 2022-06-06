package com.filwsx.mybatis.test;

import com.filwsx.mybatis.mapper.DynamicSQLMapper;
import com.filwsx.mybatis.pojo.Emp;
import com.filwsx.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author filwsx
 * @create 2022-06-06 19:49
 */
public class DynamicMapperTest {

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list1 = mapper.getEmpByIf(new Emp(null, "王五", null, "", null));
        List<Emp> list2 = mapper.getEmpByWhere(new Emp(null, "张三", null, "", null));
        List<Emp> list3 = mapper.getEmpByTrim(new Emp(null, "李四", null, "", null));
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        // List<Emp> list = mapper.getEmpByChoose(new Emp(null, "李四", 33, "", ""));
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "", 33, "", ""));
        System.out.println(list);
    }

    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a1",23,"男","123@qq.com");
        Emp emp2 = new Emp(null,"a2",23,"男","123@qq.com");
        Emp emp3 = new Emp(null,"a3",23,"男","123@qq.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        // System.out.println(dynamicSQLMapper.insertMoreByList(emps));
    }
}
