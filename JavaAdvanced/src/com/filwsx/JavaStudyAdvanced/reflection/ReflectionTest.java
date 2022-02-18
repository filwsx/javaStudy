package com.filwsx.JavaStudyAdvanced.reflection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author filwsx
 * @date 2022-02-18 11:39
 */
public class ReflectionTest {

    //使用反射创建对象，并操作属性
    @Test
    public void UsingReflection() throws Exception{

        Class cla = Person.class;

        //通过反射调用public构造器
        Constructor cons = cla.getConstructor(String.class,int.class);
        Person p = (Person) cons.newInstance("filwsx",35);
        System.out.println(p);

        //通过反射调用private方法
        Method eating = cla.getDeclaredMethod("eating",double.class);
        eating.setAccessible(true);
        boolean result = (boolean)eating.invoke(p,1.2);
        System.out.println(result);

        //通过反射调用private属性
        Field age = cla.getDeclaredField("age");
        age.setAccessible(true);
        age.set(p,15);
        System.out.println(p);

        //通过反射调用private构造器
        Constructor consPrivate = cla.getDeclaredConstructor(String.class);
        consPrivate.setAccessible(true);
        Person p2 = (Person) consPrivate.newInstance("Tom");
        System.out.println(p2);

        //通过反射调用public属性
        Field id = cla.getField("id");
        id.set(p2,19890604);
        System.out.println(p2.id);

        //通过反射调用public方法
        Method walk = cla.getMethod("walk");
        walk.invoke(p);

        //本部分为理解后，自己手打，到第二遍会自己写了。 1303
    }
}
