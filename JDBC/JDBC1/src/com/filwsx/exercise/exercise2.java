package com.filwsx.exercise;

import com.filwsx.bean.Customer;
import com.filwsx.bean.Student;
import com.filwsx.utils.JDBCutils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author filwsx
 * @date 2022-03-08 11:39
 */
public class exercise2 {

    public static void main(String[] args){
        System.out.println("请输入学生的考号：");
        Scanner scanner = new Scanner(System.in);
        String examCard = scanner.next();
        String sql = "delete from examstudent where examCard = ?";
        int deleteCount = JDBCutils.insert(sql, examCard);
        if(deleteCount > 0){
            System.out.println("删除成功");
        }else{
            System.out.println("查无此人，请重新输入");
        }
    }

    public static void main2(String[] args){
        System.out.println("请选择您要输入的类型：");
        System.out.println("a.准考证号");
        System.out.println("b.身份证号");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.next();
        if("a".equalsIgnoreCase(selection)){//if(selection.equalsIgnoreCase("a")){
            System.out.println("请输入准考证号：");
            String examCard = scanner.next();
            String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where examCard = ?";

            List<Student> list = JDBCutils.getList(Student.class,sql,examCard);
            if(list.size() != 0){
                list.forEach(System.out::println);
            }else{
                System.out.println("输入的准考证号有误！");
            }

        }else if("b".equalsIgnoreCase(selection)){
            System.out.println("请输入身份证号：");
            String IDCard = scanner.next();
            String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where IDCard = ?";

            List<Student> list = JDBCutils.getList(Student.class,sql,IDCard);
            if(list.size() != 0){
                list.forEach(System.out::println);
            }else{
                System.out.println("输入的身份证号有误！");
            }
        }else{
            System.out.println("您的输入有误，请重新进入程序。");
        }
    }

    public static void main1(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("四级/六级：");
        int type = scanner.nextInt();
        System.out.print("身份证号：");
        String IDCard = scanner.next();
        System.out.print("准考证号：");
        String examCard = scanner.next();
        System.out.print("学生姓名：");
        String studentName = scanner.next();
        System.out.print("所在城市：");
        String location = scanner.next();
        System.out.print("考试成绩：");
        int grade = scanner.nextInt();

        String sql = "insert into examstudent(type,IDCard,examCard,studentName,location,grade)values(?,?,?,?,?,?)";
        int insertCount = JDBCutils.insert(sql,type,IDCard,examCard,studentName,location,grade);
        if(insertCount > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    //构想：传入任意类对象组成的list，自动生成sql语句，批量插入
    //不会写，发现自己对集合、泛型、反射掌握很差！！！ 20220308 1208 放弃
    //public boolean insertByObject(List<T> list){ //参数不能这么写！因为忘记声明为泛型方法了
    //https://docs.oracle.com/javase/tutorial/extra/generics/methods.html
    public <T> boolean insertByObject(Class<T> cla,List<T> list){
        try {
            String sql = "insert into ";
            T t = cla.newInstance();
            String tableName = t.getClass().getName().toLowerCase(Locale.ROOT);
            System.out.println(tableName);
            Field field[] = cla.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                //放弃了，但是这么一搞我进一步理解了泛型、反射、集合的使用了！
                //这种实现耦合是不是高了？
            }

            for (int i = 0; i < list.size(); i++) {
                //JDBCutils.insert(sql,)
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Test
    public void test(){
        Field field[]  = Customer.class.getDeclaredFields();
        List<Customer> list = new ArrayList<Customer>();
        for(Field f : field){
            System.out.println(f.getName().toLowerCase(Locale.ROOT));
        }
        insertByObject(Customer.class,list);
    }
}
