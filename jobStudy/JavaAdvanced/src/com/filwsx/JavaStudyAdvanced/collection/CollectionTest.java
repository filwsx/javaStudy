package com.filwsx.JavaStudyAdvanced.collection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author filwsx
 * @date 2022-02-07 15:36
 */
public class CollectionTest {

    @Test
    public void test5(){
        Collection coll = new ArrayList();
        coll.addAll(Arrays.asList(456,123,new Person("Jerry",20),new String("Tom"),false));

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 --->数组：toArray()
        Object[] arr = coll.toArray();
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        //以下两个例子，存储内容看似一样，但长度不一致
        List arr1 = Arrays.asList(new int[]{123, 456});
        List arr2 = Arrays.asList(123, 456);
        System.out.println(arr1.size());//1
        System.out.println(arr2.size());//2
        List arr3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr3.size());//2

    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = new ArrayList();
        coll1.addAll(Arrays.asList(123,789,456));
        coll1.retainAll(coll);
        System.out.println(coll1);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        coll1.clear();
        coll1.addAll(Arrays.asList(456,123,new Person("Jerry",20),new String("Tom"),false));
        System.out.println(coll.equals(coll1));
        System.out.println(coll);
        System.out.println(coll1);
        coll1.clear();
        coll1.addAll(Arrays.asList(123,456,new Person("Jerry",20),new String("Tom"),false));
        System.out.println(coll.equals(coll1));
        System.out.println(coll);
        System.out.println(coll1);
        //对比发现，这种对比要求元素顺序一致 20220208 1151
    }

    @Test
    public void test3(){
        //3.remove(Object obj):从当前集合中移除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        System.out.println(coll);

        coll.remove(1234);
        System.out.println(coll);
        coll.remove(123);
        System.out.println(coll);
        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4. removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);

    }

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

        Collection coll1 = Arrays.asList(123,4567);
        System.out.println(coll.containsAll(coll1));
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
