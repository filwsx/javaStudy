package com.filwsx.JavaStudyAdvanced.basicClass;

import org.junit.Test;

/**
 * @author filwsx
 * @date 2022-02-04 19:49
 */
public class StringTest {
    //以下是面试题的代码，开始
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    //以上是面试题的代码，结束

    @Test
    public void test2(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s6.intern();//返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);//true
    }
    @Test
    public void StringCreatTest(){
        //String特有的方式，字面量声明
        String s1 = "Spring";
        String s2 = "Spring";
        //对象的创建方式
        String s3 = new String("Spring");
        String s4 = new String("Spring");
        System.out.println(s1==s2); //true
        System.out.println(s1==s3); //false
        System.out.println(s3==s4); //false
        System.out.println(s3.equals(s4)); //true
        System.out.println(s1.equals(s3)); //true
    }

    @Test
    public void test(){
        //常量池中字符串的存储，通过比较地址来观察
        String s1 = "filwsx";
        String s2 = "filwsx";
        System.out.println(s1==s2);
        s2 = "test";
        System.out.println(s1==s2);
        System.out.println("************");

        //replace函数并不是在s2的内容上直接修改
        System.out.println(s2);
        s2.replace('t','b');
        System.out.println(s2);
        String s3 = s2.replace('t','b');
        System.out.println(s3);
        String s4 = s3;
        System.out.println(s3 += "abc");
        System.out.println(s3 == s4);
    }
}
