package com.filwsx.thread;

/**
 * @author filwsx
 * @date 20220202 14:45
 */
public class RunnableTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        t1.start();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("Hello,filwsx!");
        }
    }
}
