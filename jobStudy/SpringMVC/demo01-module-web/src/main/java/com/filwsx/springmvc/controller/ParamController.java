package com.filwsx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author filwsx
 * @create 2022-05-04 13:31
 */
@Controller
public class ParamController {
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest re){
        String username = re.getParameter("username");
        String password = re.getParameter("password");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(String username, String password){
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return "success";
    }
}
