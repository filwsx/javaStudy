package com.filwsx.mybatis.mapper;

import com.filwsx.mybatis.pojo.Emp;

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

}
