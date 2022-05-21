package com.filwsx.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author filwsx
 * @create 2022-05-21 10:08
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
