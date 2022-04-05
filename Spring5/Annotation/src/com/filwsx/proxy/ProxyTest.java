package com.filwsx.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author filwsx
 * @create 2022-04-05 19:03
 */
public class ProxyTest {

    // 静态代理
    @Test
    public void staticProxyTest(){

    }

    // 动态代理
    @Test
    public void JDKTest(){
        Class[] interfaces = {Hello.class};

        HelloWorld helloWorld = new HelloWorld();

        Hello hello = (Hello) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),interfaces,new HelloProxy(helloWorld));

        // hello.morning("chandler！");
        hello.night("chandler！");
    }
}
