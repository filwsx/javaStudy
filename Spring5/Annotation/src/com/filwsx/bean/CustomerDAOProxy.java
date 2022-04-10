package com.filwsx.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author filwsx
 * @create 2022-04-10 11:23
 */

@Component
@Aspect
public class CustomerDAOProxy {

//    @Before(value = "execution(* com.filwsx.bean.CustomerDAO.add(..))")
//    public void before(){
//        System.out.println("before......");
//    }

    //相同切入点抽取
    @Pointcut(value = "execution(* com.filwsx.bean.CustomerDAO.add(..))")
    public void point() {

    }

    //前置通知
    //@Before注解表示作为前置通知
    @Before(value = "point()")
    public void before() {
        System.out.println("before.........");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "point()")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }

    //最终通知
    @After(value = "point()")
    public void after() {
        System.out.println("after.........");
    }

    //异常通知
    @AfterThrowing(value = "point()")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }

    //环绕通知
    @Around(value = "point()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");

        //被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后.........");
    }

}
