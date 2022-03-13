package com.filwsx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author filwsx
 * @date 2022-03-13 16:48
 */
public class addServlet extends HttpServlet {
    // 修改页面后可能需要清理浏览器缓存
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        String fname = req.getParameter("fname");
        String fprice = req.getParameter("fprice");
        String fcount = req.getParameter("fcount");
        String remark = req.getParameter("remark");

        Integer price = Integer.parseInt(fprice);
        Integer count = Integer.parseInt(fcount);

        System.out.println(fname);
        System.out.println(price);
        System.out.println(count);
        System.out.println(remark);
    }
}
