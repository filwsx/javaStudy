package com.filwsx.thread;

import static java.lang.Thread.sleep;

/**
 * @author filwsx
 * @date 20220202 16:27
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        SellerBetter ss1 = new SellerBetter();
        Thread tt1 = new Thread(ss1);
        Thread tt2 = new Thread(ss1);
        Thread tt3 = new Thread(ss1);
        tt1.setName("2号窗口");
        tt2.setName("1号窗口");
        tt3.setName("3号窗口");
        tt1.start();
        tt2.start();
        tt3.start();
    }
}

class SellerBetter implements Runnable{
    private int ticket = 1000;   //因为只需要创建一个对象，传入到多个线程对象之中，所以并不需要static修饰
    Object obj = new Object();  //任何一个对象都可充当锁，this关键字用自己也可，只要唯一
    @Override
    public void run() {
        while(true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj){
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖的，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}