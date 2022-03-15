package com.filwsx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author filwsx
 * @Date 20220315 16:36
 */
public class demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这里要覆写原方法，不能调用super，调用会出错
        HttpSession hs = req.getSession();
        System.out.println("Session ID:" + hs.getId());
    }
}
