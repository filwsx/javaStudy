package com.filwsx.JavaStudyAdvanced.basicClass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author filwsx
 * @date 2022-02-05 19:20
 */
public class DateTimeTest {

    //某个人从某天开始三天打鱼两天晒网，计算给定的某天他在干嘛。
    @Test
    public void exercise() throws ParseException {
        String began = "1998-01-11";
        String now = "2022-02-06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date beganDate = sdf.parse(began);
        Date nowDate = sdf.parse(now);
        long day = (nowDate.getTime() - beganDate.getTime())/(3600*1000*24);
        int is = (int)day%5;
        if(is<=3 && is>=1){
            System.out.println("打渔中");
        }else{
            System.out.println("筛网中");
        }
        System.out.println(day);
    }
    @Test
    public void testSimpleDateFormat() throws ParseException, ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 --->字符串
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "2022-02-06 下午07:05";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //*************按照指定的方式格式化和解析：调用带参的构造器*****************
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2019-02-18 11:48:27
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = sdf1.parse("02/06/2022 19:21:27");
        System.out.println(date2);
    }

    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());   //Sat Feb 05 19:26:00 CST 2022
        System.out.println(date1.getTime());    //1644060360814

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1644060360814L);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1644060360814L);
        System.out.println(date3);

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
        Date date4 = new java.sql.Date(1644060360814L);
        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }

    //System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time); //1644060173474
    }
}
