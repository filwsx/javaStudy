package com.filwsx.JavaStudyAdvanced.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author filwsx
 * @date 2022-02-15 19:48
 *
 * 类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，都是G类
 *
 */

public class genericsTest {
    @Test
    public void test1(){
        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
        //list1 = list2;
        /*
        反证法：
        假设list1 = list2;
           list1.add(123);导致混入非String的数据。出错。
         */
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
    /*
    2. 通配符的使用
       通配符：?
       类A是类B的父类，G<A>和G<B>是没有关系的
     */
    @Test
    public void test2(){
        List<Object> list1 = null;
        List<String> list2 = null;

        list1=Arrays.asList(123,456,789);
        list2=Arrays.asList("AA","BB","CC");
        List<?> list = null;

        list = list1;
        list = list2;
        //编译通过
        print(list1);
        print(list2);

        //对于List<?>就不能向其内部添加数据,除null之外。
//        list.add("DD");
//        list.add('?');
        // 也会运行异常
//        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);
    }
}
