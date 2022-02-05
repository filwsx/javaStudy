package com.filwsx.JavaStudyAdvanced.basicClass;

import org.junit.Test;

/**
 * String类常用方法
 * @author filwsx
 * @date 2022-02-05 12:41
 */
public class StringMethodTest {
    public static void main(String[] args) {

    }
    @Test
    public void test4(){
        String str1 = "北京市人民政府，北京人儿";
        String str2 = str1.replace('北', '东');
        System.out.println(str1);
        System.out.println(str2);
        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);

        String str = "12hello34world5java7891mysql456";
        //"\\d+"：匹配数字
        // "^,|,$"：匹配开头和结尾的"，"
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        str = "12345";
        //判断str是否全部由数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);

        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();

        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }

    @Test
    public void test3(){
        String str1 = "hellowworld";

        boolean b1 = str1.endsWith("rld");  //是否以"rld"结尾
        System.out.println(b1);
        boolean b2 = str1.startsWith("He"); //是否以"He"开头
        System.out.println(b2);
        boolean b3 = str1.startsWith("ll",2);   //从索引2开始，是否以"ll"开头
        System.out.println(b3);

        String str2 = "wor";
        System.out.println(str1.contains(str2));    //是否包含str字符串

        System.out.println(str1.indexOf("lol"));    //第一次出现"lol"的索引
        System.out.println(str1.indexOf("lo",5));   //从索引5开始，第一次出现"lo"的索引
        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));     //最后一次出现"or"的索引
        System.out.println(str3.lastIndexOf("or",5));   //从索引0-5，最后一次出现"or"的索引

    }

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));  //比较字符串内容
        System.out.println(s1.equalsIgnoreCase(s2));    //比较字符串内容，不考虑大小写

        String s3 = "abc";
        System.out.println(s3.concat("def"));   //合并字符串

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//可用于字符串排序

        String s7 = "filwsx";
        String s8 = s7.substring(2);    //从索引2开始截取
        System.out.println(s7);
        System.out.println(s8);

        String s9 = s7.substring(2, 5); //截取索引2-5，包含2不包含5
        System.out.println(s9);
    }

    @Test
    public void Test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());    //获取长度
        System.out.println(s1.charAt(0));   //获取第x个字符
        System.out.println(s1.charAt(9));
        //System.out.println(s1.charAt(10));
        System.out.println(s1);//s1不变
        System.out.println(s1.toLowerCase());//转为小写字母
        System.out.println(s1.toUpperCase());//转为大写字母

        //判断是否为空
        System.out.println(s1.isEmpty());
        s1 = "";
        System.out.println(s1.isEmpty());

        String s3 = "   he  llo   world   ";
        String s4 = s3.trim();  //去掉开头和结尾的空格，用户注册时，输入检查
        System.out.println("-----" + s3 + "-----");
        System.out.println("-----" + s4 + "-----");
    }
}
