package com.filwsx.bean;

/**
 * @author filwsx
 * @create 2022-04-01 16:43
 */
public class Book {
    private String name;
    private String author;

    public Book() {

    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        System.out.println("Book含参构造器执行了");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Book的setName方法执行了");
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
