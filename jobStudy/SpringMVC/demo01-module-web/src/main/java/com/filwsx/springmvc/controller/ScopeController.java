package com.filwsx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author filwsx
 * @create 2022-05-05 10:14
 */
@Controller
public class ScopeController {
    @RequestMapping("/scopeControllerServletAPI")
    public String scopeControllerServletAPI(HttpServletRequest request){
        request.setAttribute("testScope","hello,servletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModeAndView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("testScope","hello,ModelAndView");
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testScope","hello,Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testScope","hello,Map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testScope","hello,ModelMap");
        return "success";
    }
}
