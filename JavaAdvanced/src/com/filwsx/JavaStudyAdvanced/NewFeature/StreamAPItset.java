package com.filwsx.JavaStudyAdvanced.NewFeature;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import com.filwsx.JavaStudyAdvanced.Annotation.PersonData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author filwsx
 * @date 2022-02-21 16:03
 */
public class StreamAPItset {

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
