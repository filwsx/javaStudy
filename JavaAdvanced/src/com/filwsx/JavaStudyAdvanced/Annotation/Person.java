package com.filwsx.JavaStudyAdvanced.Annotation;

import java.util.Objects;

/**
 * @author filwsx
 * @date 2022-02-08 11:24
 */
public class Person implements Comparable{
    private String name;
    private int age ;

    @MyAnnotation
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
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
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person person = (Person) o;
            int res = this.name.compareTo(person.name);
            if(res == 0){
                return Integer.compare(this.age,person.age);
            }else{
                return res;
            }
        }else{
            throw new RuntimeException("类型不匹配");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}