package com.filwsx.JavaStudyAdvanced.reflection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author filwsx
 * @date 2022-02-18 11:39
 */
public class ReflectionTest {

    //使用反射创建对象，并操作属性
    @Test
    public void UsingReflection() throws Exception{
        Class cla = Person.class;
        Constructor cons = cla.getConstructor(String.class,int.class);
        Person p = (Person) cons.newInstance("filwsx",35);
        System.out.println(p);
    }
}
