package com.filwsx.servlet;

import com.filwsx.DAO.FruitDAOimplNoCon;
import com.filwsx.bean.Fruit;
import com.filwsx.view.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author filwsx
 * @Date 2022-03-17 16:36
 */

@WebServlet("/index")
public class indexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FruitDAOimplNoCon fruitDAO = new FruitDAOimplNoCon();
        List<Fruit> fruitList = fruitDAO.getAll();
        HttpSession session = req.getSession();
        session.setAttribute("fruitList",fruitList);
        super.processTemplate("index",req,resp);
        //System.out.println(fruitList);
    }
}
