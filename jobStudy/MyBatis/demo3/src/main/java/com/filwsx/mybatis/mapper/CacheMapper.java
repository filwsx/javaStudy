package com.filwsx.mybatis.mapper;

import com.filwsx.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author filwsx
 * @create 2022-06-07 8:51
 */
public interface CacheMapper {
    Emp getEmpById(@Param("eid") Integer eid);
}
