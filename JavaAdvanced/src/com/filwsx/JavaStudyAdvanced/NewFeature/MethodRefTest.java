package com.filwsx.JavaStudyAdvanced.NewFeature;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author filwsx
 * @date 2022-02-20 22:15
 */
public class MethodRefTest {
    // 情况一：对象 :: 实例方法
    // Consumer中的void accept(T t) 与 PrintStream中的void println(T t)
    @Test
    public void test1() {
        //原本的实现方式
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");
        //使用方法引用
        Consumer<String> con2 = (System.out)::println;
        con2.accept("beijing");

        System.out.println("*******************");
        Person person = new Person("filwsx",35);
        Supplier<String> con3 = () -> person.getName();
        System.out.println(con3.get());
        Supplier<Integer> con4 = person :: getAge;
        System.out.println(con4.get());

    }
}
