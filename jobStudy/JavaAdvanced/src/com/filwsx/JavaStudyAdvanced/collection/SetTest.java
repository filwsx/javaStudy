package com.filwsx.JavaStudyAdvanced.collection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author filwsx
 * @date 2022-02-08 16:00
 */
public class SetTest {
    @Test
    public void HashSetTest(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));
        //只重写equals，不调用equals，添加的是两个。还得重写hash

        Iterator iter = set.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }

}
