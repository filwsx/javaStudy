package com.filwsx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author filwsx
 * @create 2022-05-05 10:14
 */
@Controller
public class ScopeController {
    @RequestMapping("/scopeControllerServletAPI")
    public String scopeControllerServletAPI(HttpServletRequest request){
        request.setAttribute("testScope","hello,servletAPI");
        return "success";
    }

}
