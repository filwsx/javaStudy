package com.filwsx.rest.controller;

import com.filwsx.rest.bean.Employee;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author filwsx
 * @create 2022-05-19 8:30
 */

@Controller
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody：" + requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("requestHeader:"+requestEntity.getHeaders());
        System.out.println("requestBody:"+requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,filwsx");
    }

    @RequestMapping(value = "/testResponseBody", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testResponseBody(){
        return "成功";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public Employee testResponseUser(){
        return new Employee(1001, "admin", "123456@110.com", 0);
    }

}
