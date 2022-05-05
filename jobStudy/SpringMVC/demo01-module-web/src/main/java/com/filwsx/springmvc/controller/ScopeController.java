package com.filwsx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        System.out.println(model.getClass().getName());
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testScope","hello,Map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testScope","hello,ModelMap");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession httpSession){
        httpSession.setAttribute("testScope","hello,httpSession");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testScope", "hello,application");
        return "success";
    }
}
