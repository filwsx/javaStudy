package com.filwsx.JavaStudyAdvanced.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author filwsx
 * @date 2022-02-08 13:22
 */
public class ListTest {
    @Test
    public void interViewTest(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);   //我猜是[1，2]，不对，2是转为String了还是索引，应该是索引 1518 我对了！！
    }

    private void updateList(List list) {
        list.remove(2);
        //list.remove(new Integer(2));
    }

    @Test
    public void ArrayListTest(){
        ArrayList arr = new ArrayList();
        arr.add("123");

        LinkedList arr2 = new LinkedList();
        arr2.add("456");
        arr2.add("789");
        arr2.add(2,"filwsx");
        //看了一下双向链表前插、删除第一个元素这两个方法，还行，不难！20220208 1450

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        arr.addAll(list1);
        System.out.println(arr);
        arr.add(1,list1);
        System.out.println(arr);
        System.out.println(arr.size());//5
        //Object get(int index):获取指定index位置的元素
        System.out.println(arr.get(1));

        int index = arr2.indexOf("filwsx");
        System.out.println(index);
        index = arr.indexOf("filwsx");
        System.out.println(index);

        arr.remove(1);
        System.out.println(arr);
    }
}
