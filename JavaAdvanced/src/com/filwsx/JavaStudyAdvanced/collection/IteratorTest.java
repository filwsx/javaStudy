package com.filwsx.JavaStudyAdvanced.collection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author filwsx
 * @date 2022-02-08 12:08
 */
public class IteratorTest {

    // 测试Iterator中的remove()
    // 在next()方法前调用remove()、在next()后调用两次remove()，都会产生IllegalStateException。
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.addAll(Arrays.asList(123,456,new Person("Jerry",20),new String("Tom"),false));
        Iterator iterator = coll.iterator();

        //删除集合中"Tom"
        while (iterator.hasNext()){
            // iterator.remove();        // 此语句执行会报异常
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
                // iterator.remove();    // 此语句执行会报异常
            }
        }

        //看了一眼源码，太复杂了来回调用，不知道ArrayList()怎么实现的iterator()、next()等方法 20220208 1250写
    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.addAll(Arrays.asList(123,456,new Person("Jerry",20),new String("Tom"),false));
        Iterator iterator = coll.iterator();

        //不推荐for结合获取coll的size来遍历，要hasNext用起来！
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // 错误实现1：
        // while((iterator.next()) != null){System.out.println(iterator.next());}

        // 错误实现2：
        // 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }
}
