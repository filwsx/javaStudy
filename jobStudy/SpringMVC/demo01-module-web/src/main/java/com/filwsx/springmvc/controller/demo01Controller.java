package com.filwsx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author filwsx
 * @create 2022-04-19 13:31
 */
@Controller
public class demo01Controller {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        return "testRequestMapping";
    }

    @RequestMapping("/testScope")
    public String testScope(){
        return "testScope";
    }

}
