package com.filwsx.JavaStudyAdvanced.reflection;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建运行时类
 * @author filwsx
 * @date 2022-02-18 14:22
 */
public class NewInstanceTest {

    public Object getInstance(String classPath) throws Exception {
        Class cla =  Class.forName(classPath);
        return cla.newInstance();
    }

    //体会反射的动态性
    @Test
    public void test2(){
        for(int i = 0;i < 20;i++){
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.filwsx.JavaStudyAdvanced.Annotation.Person";
                    break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() throws Exception{
        Class<Person> clss = Person.class;
        Person p1 = clss.newInstance();
        System.out.println(p1);
    }
}
