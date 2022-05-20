package com.filwsx.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author filwsx
 * @create 2022-05-19 12:03
 */

@ControllerAdvice
public class ExceptController2 {

    //@ExceptionHandler用于设置所标识方法处理的异常
    @ExceptionHandler(NegativeArraySizeException.class)
    //ex表示当前请求处理中出现的异常对象
    public String handleArithmeticException(Exception ex, Model model){
        model.addAttribute("ex", ex);
        return "error";
    }
}
