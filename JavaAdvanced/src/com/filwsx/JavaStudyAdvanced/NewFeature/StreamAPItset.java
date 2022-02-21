package com.filwsx.JavaStudyAdvanced.NewFeature;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import com.filwsx.JavaStudyAdvanced.Annotation.PersonData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author filwsx
 * @date 2022-02-21 16:03
 */
public class StreamAPItset {

    //测试Stream的中间操作：筛选与切片、映射、排序
    @Test
    public void test2(){
        List<Person> personList = PersonData.getPersonList();
        Stream<Person> streamPerson = personList.stream();

        //-----------------筛选与切片------------------//
        //筛选年龄大于35岁的人
        System.out.println("要优化的名单是:");
        streamPerson = personList.stream();
        streamPerson.filter(person -> person.getAge()>35).forEach(System.out::println);
        System.out.println();

        //limit(n)截断流，使其元素不超过给定数量
        streamPerson = personList.stream();
        streamPerson.limit(2).forEach(System.out::println);
        System.out.println();

        //skip(n)跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        streamPerson = personList.stream();
        streamPerson.skip(2).forEach(System.out::println);
        System.out.println();

        //distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        personList.add(new Person("马化腾", 34));
        personList.add(new Person("马化腾", 36));
        personList.add(new Person("马肥腾", 34));
        personList.add(new Person("马化腾", 34));
        System.out.println("去重之前：");
        personList.stream().forEach(System.out::println);
        System.out.println("去重之后：");
        personList.stream().distinct().forEach(System.out::println);

        //-----------------映射------------------//
        //map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aba", "bcb", "cec", "dad");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        //以下这两句看的我太费劲了，每一步传参，输入输出是啥不清楚！ 20220221 1752写
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPItset::fromStringToStream);
        streamStream.forEach(ss -> ss.forEach(System.out::println));
    }

    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    //Stream的实例化
    @Test
    public void test1(){
        //方式一：通过集合
        List<Person> personList = PersonData.getPersonList();
        Stream<Person> streamPerson = personList.stream();
        Stream<Person> parallelStreamPerson = personList.parallelStream();

        //方式二：通过数组
        int array[] = new int[]{1,2,3,4,5,6,7,8,9,0};
        //Stream<Integer> streamInteger = Arrays.stream(array);
        IntStream streamInteger = Arrays.stream(array);

        //方式三：通过Stream的of()
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9,0);

        //方式四：创建无限流(使用迭代器+lambda表达式产生无限个数)
        Stream.iterate(1,t -> t+2).limit(20).forEach(System.out::print);

    }
}
