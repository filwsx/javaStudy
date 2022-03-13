package com.filwsx.DAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author filwsx
 * @date 2022-03-13 17:26
 */
public interface DAO <T>{

    /**
     * 将对象添加到数据库中
     * @param conn
     * @param t
     */
    void insert(Connection conn, T t);

    /**
     * 针对指定的id，删除表中的一条记录
     * @param conn
     * @param id
     */
    void deleteById(Connection conn,int id);

    /**
     * 针对内存中的对象，去修改数据表中指定的记录
     * @param conn
     * @param t
     */
    void update(Connection conn,T t,int id);

    /**
     * 针对指定的id查询得到对应的对象
     * @param conn
     * @param id
     * @return
     */
    T getItemById(Connection conn,int id);

    /**
     * 查询表中的所有记录构成的集合
     * @param conn
     * @return
     */
    List<T> getAll(Connection conn);

    /**
     * 返回数据表中的数据的条目数
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

}
