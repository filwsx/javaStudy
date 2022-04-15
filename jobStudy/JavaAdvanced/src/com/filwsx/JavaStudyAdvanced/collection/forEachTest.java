package com.filwsx.JavaStudyAdvanced.collection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author filwsx
 * @date 2022-02-08 12:52
 */
public class forEachTest {

    @Test
    public void test2(){
        String[] arr = new String[]{"MM","MM","MM"};

        //方式一：普通for赋值
        for(int i = 0;i < arr.length;i++){
            arr[i] = "GG";
        }
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

        //方式二：增强for循环
        for(String s : arr){
            s = "MM";
        }
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.addAll(Arrays.asList(456,123,new Person("Jerry",20),new String("Tom"),false));
        Iterator iterator = coll.iterator();

        for(Object obj:coll){
            System.out.println(obj);
        }
    }
}
