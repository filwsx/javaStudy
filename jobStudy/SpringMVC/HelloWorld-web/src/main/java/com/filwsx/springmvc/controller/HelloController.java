package com.filwsx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author filwsx
 * @create 2022-04-18 9:32
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/index")
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/index2")
    public String getIndex(){
        return "index2";
    }
}
