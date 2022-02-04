package com.filwsx.JavaStudyAdvanced.thread;

public class threadTest{
    public static void main(String[] args) {
        printHello PH = new printHello();
        printMe PM = new printMe();
        //PH.start();
        //PM.start();

        Thread t1 = new Thread(){
            public void run() {
                while (true){
                    System.out.println("Me");
                }
            }
        };
        Thread t2 = new Thread(){
            public void run() {
                while (true){
                    System.out.println("Hello");
                }
            }
        };
        t1.start();
        t2.start();
    }
}

class printMe extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println("ME");
        }
    }
}

class printHello extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println("Hello");
        }
    }
}