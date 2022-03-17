package com.filwsx.thymeleaf;

import com.filwsx.DAO.FruitDAO;
import com.filwsx.DAO.FruitDAOimpl;
import com.filwsx.JDBCutils.JDBCutils;
import com.filwsx.bean.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * @author filwsx
 * @Date 2022-03-17 16:36
 */

@WebServlet("/index")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FruitDAO fruitDAO = new FruitDAOimpl();
        Connection con = null;
        List<Fruit> fruitList = null;
        try {
            con = JDBCutils.getConnection();
            fruitList = fruitDAO.getAll(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        session.setAttribute("fruitList",fruitList);
    }
}
