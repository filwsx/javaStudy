package com.filwsx.JavaStudyAdvanced.reflection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author filwsx
 * @date 2022-02-18 20:15
 */
public class FieldTest {

    @Test
    public void test2(){
        Class cla = Person.class;
        Field[] declaredFields = cla.getDeclaredFields();
        for(Field f : declaredFields){
            int modifier  =f.getModifiers();
            Class type = f.getType();
            String fieldName = f.getName();
            System.out.print(Modifier.toString(modifier) + "\t");
            System.out.print(type.getName() + "\t");
            System.out.println(fieldName);
        }
    }
    @Test
    public void test1(){
        Class cla = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field fields[] = cla.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        System.out.println("");

        //获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field declareFields[] = cla.getDeclaredFields();
        for(Field f:declareFields){
            System.out.println(f);
        }

    }
}
