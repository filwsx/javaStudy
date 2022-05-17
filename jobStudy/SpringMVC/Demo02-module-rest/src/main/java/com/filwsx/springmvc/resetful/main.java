package com.filwsx.springmvc.resetful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author filwsx
 * @create 2022-05-17 13:13
 */
@Controller
public class main {

    @RequestMapping("/")
    public String main(){
        return "main";
    }
}
