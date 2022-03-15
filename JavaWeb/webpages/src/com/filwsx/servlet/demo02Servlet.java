package com.filwsx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class demo02Servlet extends HttpServlet {

    public demo02Servlet(){
        System.out.println("正在实例化demo02....");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化...");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务中...");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("销毁...");
    }
}

