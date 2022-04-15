package com.filwsx.JavaStudyAdvanced.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author filwsx
 * @date 2022-02-16 9:19
 */
public class Order<T> {
    String name;
    int id;
    T orderT;

    public Order(){
        T arr[] = (T[]) new Object[10];
    }

    public Order(String name,int id,T orderT){
        this.name = name;
        this.id = id;
        this.orderT = orderT;
    }

    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;
    }

}
