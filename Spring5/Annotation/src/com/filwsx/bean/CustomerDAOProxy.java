package com.filwsx.bean;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author filwsx
 * @create 2022-04-10 11:23
 */

@Component
@Aspect
public class CustomerDAOProxy {

    @Before(value = "execution(* com.filwsx.bean.CustomerDAO.add(..))")
    public void before(){
        System.out.println("before......");
    }
}
