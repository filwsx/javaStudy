package com.filwsx.DAO;

import com.filwsx.JDBCutils.JDBCutils;
import com.filwsx.bean.Fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @author filwsx
 * @Date 2022-03-17 18:00
 */
public class FruitDAOimplNoCon {

    private Connection conn = null;
    private FruitDAO fruitDAO = new FruitDAOimpl();

    {
        try {
            conn = JDBCutils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(Fruit fruit) {
        fruitDAO.insert(conn,fruit);
    }

    public void deleteById(int id) {
        fruitDAO.deleteById(conn,id);
    }

    public void update(Fruit fruit,int id) {
        fruitDAO.update(conn,fruit,id);
    }

    public Fruit getItemById(int id) {
        return fruitDAO.getItemById(conn,id);
    }

    public List<Fruit> getAll() {
        return fruitDAO.getAll(conn);
    }

    public Long getCount() {
        return fruitDAO.getCount(conn);
    }
}
