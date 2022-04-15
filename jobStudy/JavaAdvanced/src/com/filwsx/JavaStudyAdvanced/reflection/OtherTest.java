package com.filwsx.JavaStudyAdvanced.reflection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 看的我辛苦的，这一部分直接copy代码吧！全是方法的使用，毫无含金量可言
 * @author filwsx
 * @date 2022-02-18 20:44
 */
public class OtherTest {

    //获取运行时类声明的注解
    @Test
    public void test6(){
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annos : annotations){
            System.out.println(annos);
        }
    }

    //获取运行时类所在的包
    @Test
    public void test5(){
        Class clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    //获取运行时类实现的接口
    @Test
    public void test4(){
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
    }

    //获取运行时类的带泛型的父类及其泛型类型
    @Test
    public void test3(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(((Class)actualTypeArguments[0]).getName());

    }

    //获取运行时类的父类
    @Test
    public void test2(){
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    //获取构造器结构
    @Test
    public void test1(){
        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }
        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }
}
