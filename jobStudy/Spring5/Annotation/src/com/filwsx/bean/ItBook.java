package com.filwsx.bean;

/**
 * @author filwsx
 * @create 2022-04-14 9:42
 */
public class ItBook {
    private int id;
    private String name;

    public ItBook(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
