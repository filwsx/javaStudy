package com.filwsx.JavaStudyAdvanced.Annotation;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author filwsx
 * @date 2022-02-08 11:24
 */
@MyAnnotation(value="hi")
public class Person extends Creature<String> implements Comparable<Person>, Serializable,MyInterface{

    public static final long serialVersionUID = 1989060419890604L;

    private String name;
    private int age ;
    public int id = 0;

    @MyAnnotation
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
        this.age = 0;
    }

    public Person(int age) {
        this.name = "name";
        this.age = age;
    }

    public Person() {
        this.name = "name";
        this.age = 0;
    }

    @MyAnnotation
    public void walk(){
        System.out.println("人走路");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("调用equals()");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person person) {
        int res = this.name.compareTo(person.name);
        if(res == 0){
            return Integer.compare(this.age,person.age);
        }else{
            return res;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private static void shopping(){
        System.out.println("去购物！");
    }

    private boolean eating(double foodWeight){
        if (foodWeight>1.0){
            return true;
        }else
            return false;
    }

    @Override
    public void info() {
        System.out.println("this is human");
    }
}