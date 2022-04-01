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
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
