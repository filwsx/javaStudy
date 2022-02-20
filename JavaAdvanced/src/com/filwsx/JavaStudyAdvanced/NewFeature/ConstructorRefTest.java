package com.filwsx.JavaStudyAdvanced.NewFeature;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author filwsx
 * @date 2022-02-20 23:15
 */
public class ConstructorRefTest {

    //
    @Test
    public void test3(){

    }

    //Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Person> fuc1 = age -> new Person(age);
        fuc1 = Person::new;
        Function<String,Person> fuc2 = name -> new Person(name);
        fuc2 = Person::new;
        MyInterface<String,Integer,Person> fuc3 = (String name,Integer age) -> new Person(name,age);
        fuc3 = Person::new;
        //经过此测试，我理解了lambda了!!! 还用上了自定义函数式接口和泛型 20220220 2329

        System.out.println(fuc1.apply(13));
        System.out.println(fuc2.apply("Tom"));
        System.out.println(fuc3.method("Jerry",12));
    }
    //Supplier中的T get() 与 Person的空参构造器：Person()
    @Test
    public void test1(){
        Supplier<Person> con1 = () -> new Person();
        con1 = Person :: new ;
        Person p = con1.get();
        p.setName("filwsx");
        p.setAge(35);
        System.out.println(p);
    }
}
