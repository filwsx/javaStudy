package com.filwsx.JavaStudyAdvanced.Annotation;

/**
 * @author filwsx
 * @date 2022-02-08 11:24
 */
public class Person{
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

}