package com.filwsx.JavaStudyAdvanced.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author filwsx
 * @date 2022-02-19 18:07
 */

interface Human{
    String getBelief();
    boolean logic(boolean proposition) ;
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public boolean logic(boolean proposition) {
        return !proposition;
    }
}

class HumanUtil{

    public void breath(){
        System.out.println("一直在呼吸");
    }

    public void eat(){
        System.out.println("饿了就吃东西");
    }
}

class ProxyFactory{
    public static Object getProxyInstance(Object obj){
        Class oooobj = obj.getClass();
        MyInvocationHandler mih = new MyInvocationHandler();
        mih.bind(obj);
        Object oobbjj = Proxy.newProxyInstance(oooobj.getClassLoader(),oooobj.getInterfaces(),mih);
        return oobbjj;
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = method.invoke(obj,args);
        return res;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superman = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        String res1 = proxyInstance.getBelief();
        boolean res2 = proxyInstance.logic(true);
        System.out.println(res1);
        System.out.println(res2);

        TomFactory tom = new TomFactory();
        ClothFactory clothFactory = (ClothFactory) ProxyFactory.getProxyInstance(tom);
        clothFactory.produceCloth();
    }
}
