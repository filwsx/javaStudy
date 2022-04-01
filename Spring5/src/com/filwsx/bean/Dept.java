package com.filwsx.bean;

import java.util.ArrayList;

/**
 * @author filwsx
 * @create 2022-04-01 18:25
 */
public class Dept {
    private String dName;

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dName='" + dName + '\'' +
                '}';
    }
}
