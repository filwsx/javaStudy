package com.filwsx.DAO;

import com.filwsx.bean.Fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @author filwsx
 * @date 2022-03-13 17:27
 */
public class fruitDAOimpl extends baseDAO implements fruitDAO {

    @Override
    public void insert(Connection conn, Fruit fruit) {
        String sql = "insert into fruit(fname,fprice,fcount,remark)values(?,?,?,?)";
        update(conn, sql,fruit.getFname(),fruit.getFprice(),fruit.getFcount(),fruit.getRemark());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from fruit where id = ?";
        update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Fruit fruit,int id) {
        String sql = "update fruit set fname = ?,fprice = ?,fcount = ?,remark = ? where id = ?";
        update(conn, sql,fruit.getFname(),fruit.getFprice(),fruit.getFcount(),fruit.getRemark(),id);
    }

    @Override
    public Fruit getItemById(Connection conn, int id) {
        String sql = "select fname,fprice,fcount,remark from fruit where id = ?";
        List<Fruit> fruitList = getList(conn,Fruit.class, sql,id);
        Fruit fruit = fruitList.get(0);
        return fruit;
    }

    @Override
    public List<Fruit> getAll(Connection conn) {
        String sql = "select fname,fprice,fcount,remark from fruit";
        List<Fruit> fruitList = getList(conn,Fruit.class, sql);
        return fruitList;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from fruit";
        return getValue(conn, sql);
    }
}
