package com.filwsx.JavaStudyAdvanced.collection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author filwsx
 * @date 2022-02-14 10:14
 */
public class interView {

    //極爲經典的題目
    @Test
    public void test2(){
        HashSet set = new HashSet();
        Person p1 = new Person("AA",1001);
        Person p2 = new Person("BB",1002);

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.setName("CC");
        set.remove(p1);     //找不到p1修改後計算出的hash，無法移除
        System.out.println(set);

        set.add(new Person("CC",1001)); //hash值為新的，可加入
        System.out.println(set);

        set.add(new Person("AA",1001));//hash一樣，但是equals不同
        System.out.println(set);
    }

    public static List du(List list){
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test(){
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = du(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }
}
