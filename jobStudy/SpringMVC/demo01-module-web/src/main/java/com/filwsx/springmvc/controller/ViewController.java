package com.filwsx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author filwsx
 * @create 2022-05-06 13:31
 */
@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }
}
