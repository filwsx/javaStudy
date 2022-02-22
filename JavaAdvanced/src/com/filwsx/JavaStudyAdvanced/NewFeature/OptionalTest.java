package com.filwsx.JavaStudyAdvanced.NewFeature;

import com.filwsx.JavaStudyAdvanced.Annotation.Boy;
import org.junit.Test;

import java.util.Optional;

/**
 * @author filwsx
 * @date 2022-02-22 16:28
 */
public class OptionalTest {

    @Test
    public void test2(){
        Boy boy = new Boy(123456L);
        boy = null;
        //ofNullable(T t)：t可以为null
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        System.out.println(optionalBoy);
        //orElse(T t1):如果单前的Optional内部封装的t是非空的，则返回内部的t.
        //如果内部的t是空的，则返回orElse()方法中的参数t1.
        Boy boy1 = optionalBoy.orElse(new Boy());
        System.out.println(boy1);

    }


    @Test
    public void test1(){
        Boy boy = new Boy();
        //of(T t):保证t是非空的
        Optional<Boy> optionalBoy = Optional.of(boy);
    }
}
