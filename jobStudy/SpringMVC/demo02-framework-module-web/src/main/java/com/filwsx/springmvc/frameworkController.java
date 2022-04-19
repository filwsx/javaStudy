package com.filwsx.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author filwsx
 * @create 2022-04-19 12:17
 */
@Controller
public class frameworkController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
