package com.filwsx.JavaStudyAdvanced.Annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @author filwsx
 * @date 2022-02-07 13:47
 */
public class AnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int me = 0;
    }

    @MyAnnotation
    public static void test(){

    }

    //这个实验虽然自己敲了一遍，但还是不理解，大概是因为有知识没有学习。运行机制、流程和原理一点都不懂。20220207 1419
    @Test
    public void testGetAnnotation(){
        Class classic = Student.class;
        Annotation MyFILWSX[]  = classic.getAnnotations();
        for (int i = 0; i < MyFILWSX.length; i++) {
            System.out.println(MyFILWSX[i]);
        }
    }
}

interface Info{
    void show();
}

@MyAnnotation("可重复注解")
@MyAnnotation("HelloWorld!")


class Student extends Person implements Info{

    public Student(String name,int age){
        super(name,age);
    }
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    public void show() {
    }
}

//泛型
class Generic<@MyAnnotation T>{

    public void show() throws @MyAnnotation RuntimeException{

        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }

}

