package com.filwsx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

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
    public String testParam(String username, String password,String [] hobby){
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("hobby:" + Arrays.toString(hobby));
        return "success";
    }

    @RequestMapping("/testParam2")
    public String testParam2(
            @RequestParam(value = "user_name",required = false,defaultValue = "2333") String username,
            @RequestParam("password") String password,
            @RequestParam("hobby") String [] hobby){
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("hobby:" + Arrays.toString(hobby));
        return "success";
    }
}
