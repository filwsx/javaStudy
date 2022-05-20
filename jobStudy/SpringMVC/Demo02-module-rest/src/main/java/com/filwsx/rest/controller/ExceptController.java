package com.filwsx.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author filwsx
 * @create 2022-05-19 12:03
 */
@Controller
public class ExceptController {

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler(){
        System.out.println(1/0);
        return "success";
    }

    @RequestMapping("/testExceptionHandler2")
    public String testExceptionHandler2(){
        int test[] = new int[-1];
        return "success";
    }
}
