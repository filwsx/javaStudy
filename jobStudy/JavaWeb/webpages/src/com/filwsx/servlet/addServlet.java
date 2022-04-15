package com.filwsx.servlet;

import com.filwsx.DAO.FruitDAO;
import com.filwsx.DAO.FruitDAOimpl;
import com.filwsx.JDBCutils.JDBCutils;
import com.filwsx.bean.Fruit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * @author filwsx
 * @date 2022-03-13 16:48
 */
public class addServlet extends HttpServlet {
    // 修改页面后可能需要清理浏览器缓存
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        req.setCharacterEncoding("UTF-8");
        String fname = req.getParameter("fname");
        String fprice = req.getParameter("fprice");
        String fcount = req.getParameter("fcount");
        String remark = req.getParameter("remark");

        Integer price = Integer.parseInt(fprice);
        Integer count = Integer.parseInt(fcount);

        FruitDAO fdi = new FruitDAOimpl();
        Connection con = null;
        try {
            con = JDBCutils.getConnection();
            Fruit fruit = new Fruit(0,fname,price,count,remark);
            fdi.insert(con,fruit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /** addFruit
        1.获取连接
        2.编写sql ：insert
        3.psmt
        4.填充参数 ： 4个参数
        5.执行更新
        6.释放资源
     */
}
