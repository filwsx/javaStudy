package com.filwsx.JavaStudyAdvanced.NewFeature;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author filwsx
 * @date 2022-02-20 22:15
 */
public class MethodRefTest {
    // 情况3：类::实例方法名
    // Comparator中的int comapre(T t1,T t2) 与 String中的int t1.compareTo(t2)
    // Function中的R apply(T t) 与 Person中的String getName();
    @Test
    public void test3() {
        Comparator<String> con1 = String :: compareTo;
        Function<Person,String> con2 = Person ::getName;
        System.out.println(con2.apply(new Person("Tom", 13)));
        System.out.println(con1.compare("abc", "abd"));
    }

    // 情况2：类::静态方法名
    //Comparator中的int compare(T t1,T t2) 与 Integer中的int compare(T t1,T t2)
    //Function中的R apply(T t) 与 Math中的Long round(Double d)
    @Test
    public void test2() {
        Comparator<Integer> con1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(con1.compare(12, 34));
        Comparator<Integer> con2 = Integer::compare;
        System.out.println(con2.compare(89, 64));

        Function<Double,Long> con3 = d -> Math.round(d);
        System.out.println(con3.apply(1.4));
        Function<Double,Long> con4 = Math::round;
        System.out.println(con4.apply(2.9));

    }

    // 情况1：对象 :: 实例方法
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
