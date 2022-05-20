package com.filwsx.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author filwsx
 * @create 2022-05-19 11:14
 */
@Controller
public class InterceptorController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
}
