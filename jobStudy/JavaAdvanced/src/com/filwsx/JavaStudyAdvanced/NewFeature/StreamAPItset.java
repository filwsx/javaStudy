package com.filwsx.JavaStudyAdvanced.NewFeature;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import com.filwsx.JavaStudyAdvanced.Annotation.PersonData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author filwsx
 * @date 2022-02-21 16:03
 */
public class StreamAPItset {

    //测试Stream终止操作：收集
    @Test
    public void test7(){
        // collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        // 练习1：查找年龄大于35的人，结果返回为一个List或Set

        List<Person> personList = PersonData.getPersonList();

        List<Person> personAgeList = personList.stream().filter(e -> e.getAge() > 35).collect(Collectors.toList());
        personAgeList.forEach(System.out::println);
        System.out.println();

        Set<Person> personAgeSet = personList.stream().filter(e -> e.getAge() > 30).collect(Collectors.toSet());
        personAgeSet.forEach(System.out::println);
    }

    //测试Stream终止操作：规约
    @Test
    public void test6(){
        // reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
        // 练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        // reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        // 练习2：计算所有人的年龄总和
        List<Person> personList = PersonData.getPersonList();
        Stream<Integer> salaryStream = personList.stream().map(Person::getAge);
        Optional<Integer> sumMoney = salaryStream.reduce((d1,d2) -> d1 + d2);
        System.out.println(sumMoney.get());
    }

    //测试Stream终止操作：匹配与查找
    @Test
    public void test5(){
        List<Person> personList = PersonData.getPersonList();

        //allMatch(Predicate p)——检查所有元素是否都匹配。
        boolean allMatch = personList.stream().allMatch(p -> p.getAge() > 0);
        System.out.println(allMatch);

        //anyMatch(Predicate p)——检查是否至少匹配一个元素。
        boolean anyMatch = personList.stream().anyMatch(p -> p.getAge() > 60);
        System.out.println(anyMatch);

        //noneMatch(Predicate p)——检查是否没有匹配的元素。
        boolean noneMatch = personList.stream().noneMatch(p -> p.getName().startsWith("刘"));
        System.out.println(noneMatch);

        //findFirst——返回第一个元素
        Optional<Person> person = personList.stream().findFirst();
        System.out.println(person);

        //findAny——返回当前流中的任意元素
        Optional<Person> person2 = personList.parallelStream().findAny();
        System.out.println(person2);

    }

    //测试Stream的中间操作：排序
    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);

        System.out.println("");

        List<Person> personList = PersonData.getPersonList();
        personList.stream().sorted((p1,p2) -> {
            int age = Integer.compare(p1.getAge(),p2.getAge());
            if(age == 0){
                return p1.getName().compareTo(p2.getName());
            }else{
                return age;
            }
        }).forEach(System.out::println);
    }
    //测试Stream的中间操作：映射
    @Test
    public void test3(){

        //map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aba", "bcb", "cec", "dad");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        //以下这两句看的我太费劲了，每一步传参，输入输出是啥不清楚！ 20220221 1752写
        //昨晚看懂了，不难嘛！20220222 1601
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPItset::fromStringToStream);
        streamStream.forEach(ss -> ss.forEach(System.out::println));

        System.out.println("");
        //flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(StreamAPItset::fromStringToStream);
        characterStream.forEach(System.out::println);

    }

    //测试Stream的中间操作：筛选与切片
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

        System.out.println("");
        //练习：获取年龄大于35岁人的姓名
        personList.stream().filter(p -> p.getAge()>35).forEach(System.out::println);
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

    //不可变集合
    @Test
    public void test0(){
        List<String> list = Arrays.asList("aba", "bcb", "cec", "dad");
        list.add("bdf");    //这里会报UnsupportedOperationException，因为这种方式声明的list为不可变，而不是list没有该操作 20220222 1144
    }
}
