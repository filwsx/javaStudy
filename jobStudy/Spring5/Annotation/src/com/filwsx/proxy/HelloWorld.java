package com.filwsx.proxy;

/**
 * @author filwsx
 * @create 2022-04-05 19:01
 */
public class HelloWorld implements Hello{
    @Override
    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }

    @Override
    public void night(String name) {
        System.out.println("Good night, " + name);
    }
}
