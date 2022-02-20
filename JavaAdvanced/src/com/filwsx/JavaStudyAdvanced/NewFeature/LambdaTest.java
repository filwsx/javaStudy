package com.filwsx.JavaStudyAdvanced.NewFeature;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author filwsx
 * @date 2022-02-19 18:40
 */
public class LambdaTest {

    @Test
    public void test2(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = com1.compare(19,89);
        System.out.println(compare1);

        System.out.println("***********************");

        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1,o2);
        int compare2 = com2.compare(6,4);
        System.out.println(compare2);

        System.out.println("***********************");

        //方法引用
        Comparator<Integer> com3 = Integer :: compare;
        int compare3 = com3.compare(19,84);
        System.out.println(compare3);
    }

    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("FILWSX");
            }
        };
        r1.run();

        System.out.println("***********************");

        Runnable r2 = () -> System.out.println("17312919.jpg");
        r2.run();
    }
}
