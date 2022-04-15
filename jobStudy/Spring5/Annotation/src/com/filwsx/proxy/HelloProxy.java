package com.filwsx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author filwsx
 * @create 2022-04-05 19:06
 */
public class HelloProxy implements InvocationHandler {
    private Object obj;

    public HelloProxy(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("方法之前执行..." + method.getName() + "的参数列表:" + Arrays.toString(args));

        Object res = method.invoke(obj,args);

        System.out.println("方法之后执行...");

        return res;
    }
}
