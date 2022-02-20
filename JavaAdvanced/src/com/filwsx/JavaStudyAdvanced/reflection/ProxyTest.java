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

    public static void breath(){
        System.out.println("一直在呼吸");
    }

    public static void eat(){
        System.out.println("饿了就吃东西");
    }
}

class ProxyFactory{
    //调用此方法，返回一个代理类的对象
    public static Object getProxyInstance(Object obj){
        Class oooobj = obj.getClass();
        MyInvocationHandler mih = new MyInvocationHandler();
        mih.bind(obj);
        Object oobbjj = Proxy.newProxyInstance(oooobj.getClassLoader(),oooobj.getInterfaces(),mih);
        return oobbjj;
    }
}

class MyInvocationHandler implements InvocationHandler{

    //obj:被代理类的对象
    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //必将执行的通用方法
        HumanUtil.breath();
        HumanUtil.eat();

        //method:代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        Object res = method.invoke(obj,args);
        return res;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superman = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String res1 = proxyInstance.getBelief();
        boolean res2 = proxyInstance.logic(true);
        System.out.println(res1);
        System.out.println(res2);

        TomFactory tom = new TomFactory();
        ClothFactory clothFactory = (ClothFactory) ProxyFactory.getProxyInstance(tom);
        clothFactory.produceCloth();
    }
}
