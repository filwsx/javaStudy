package com.filwsx.JavaStudyAdvanced.NewFeature;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author filwsx
 * @date 2022-02-19 18:40
 */
public class LambdaTest {

    //Predicate函数式
    //看完代码后，根据理解自己的写的！ 20220220 2137
    @Test
    public void test4(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京","京东","京东方");
        //List<String> res = filterString(list,(s,c) -> s.contains((String)c)); //这样写不行
        List<String> res = filterString(list,s -> s.contains("京"));
        System.out.println(res);
    }

    public List<String> filterString(List<String> list , Predicate<String> pre){
        //List<String> res = Arrays.asList(); //这样写不行，为什么
        ArrayList<String> res = new ArrayList<>();
        for(String s:list){
            if(pre.test(s)){
                res.add(s);
            }
        }
        return res;
    }

    //Consumer函数式
    //看完代码后，根据理解，自己的写的！ 20220220 2115
    @Test
    public void test3(){
        badTime(520,money2 -> System.out.println("送女朋友礼物花了"+money2+"元"));
        badTime(250,money2 -> System.out.println("刚送完礼物，分手吃饭花了"+money2+"元"));
    }

    public void badTime(double money , Consumer<Double> consumer){
        consumer.accept(money);
    }

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
