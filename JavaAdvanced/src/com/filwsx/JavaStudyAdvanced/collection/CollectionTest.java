package com.filwsx.JavaStudyAdvanced.collection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author filwsx
 * @date 2022-02-07 15:36
 */
public class CollectionTest {
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(456);
        coll.add(123);
        coll.add(new String("Jerry"));
        Person p = new Person("me",35);
        coll.add(p);
        boolean contains = coll.contains(123);
        System.out.println(contains);
        contains = coll.contains("Jerry");
        System.out.println(contains);
        contains = coll.contains(new String("Jerry"));  //说明判断是否存在，调用了equals方法比较内容，而不是引用地址 20220208 1128
        System.out.println(contains);
        contains = coll.contains(new Person("me",35));
        System.out.println(contains);

    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //add(Object e):将元素e添加到集合coll中
        coll.add("Wu");
        coll.add("Long");
        coll.add("Fei");
        coll.add(123);//自动装箱
        coll.add(LocalDate.now());

        //size():获取添加的元素的个数
        System.out.println(coll.size());//4

        //addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());//6
        System.out.println(coll);

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }
}
