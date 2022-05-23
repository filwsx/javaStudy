package com.filwsx.mybatis.mapper;

import com.filwsx.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author filwsx
 * @create 2022-05-23 12:00
 */
public interface SQLMapper {

    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     */
    void insertUser(User user);

}
