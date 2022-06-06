package com.filwsx.mybatis.mapper;

import com.filwsx.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author filwsx
 * @create 2022-06-06 19:35
 */
public interface DynamicSQLMapper {

    /**
     * 多条件查询
     */
    List<Emp> getEmpByIf(Emp emp);

    List<Emp> getEmpByWhere(Emp emp);

    List<Emp> getEmpByTrim(Emp emp);

    /**
     * 测试choose、when、otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

}
