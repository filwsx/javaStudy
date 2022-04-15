package com.filwsx.JavaStudyAdvanced.collection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author filwsx
 * @date 2022-02-08 18:21
 */
public class TreeSetTest {

    @Test
    public void Test2(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person u1 = (Person)o1;
                    Person u2 = (Person)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet objects = new TreeSet(com);
        objects.add(new Person("Tom",12));
        objects.add(new Person("Jerry",32));
        objects.add(new Person("Jim",2));
        objects.add(new Person("Mike",65));
        objects.add(new Person("Jack",33));
        objects.add(new Person("Jack",56));
        objects.add(new Person("JackMa",33));

        for(Object obj:objects){
            if(obj instanceof Person){
                Person person = (Person) obj;
                System.out.println(person.getName() + "\t" + person.getAge());
            }else{
                System.out.println(obj);
            }
        }
    }

    @Test
    public void Test(){
        TreeSet objects = new TreeSet();
        objects.add(new Person("Tom",12));
        objects.add(new Person("Jack",33));
        objects.add(new Person("Jerry",32));
        objects.add(new Person("Jim",2));
        objects.add(new Person("Mike",65));
        objects.add(new Person("Jack",56));

        for(Object obj:objects){
            if(obj instanceof Person){
                Person person = (Person) obj;
                System.out.println(person.getName() + "\t" + person.getAge());
            }else{
                System.out.println(obj);
            }
        }
    }
}
