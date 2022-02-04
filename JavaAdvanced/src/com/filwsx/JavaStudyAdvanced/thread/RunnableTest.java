package com.filwsx.JavaStudyAdvanced.thread;

/**
 * @author filwsx
 * @date 20220202 14:45
 */
public class RunnableTest {
    public static void main(String[] args) {
        Thread t0 = new Thread(new MyThread());
        //t0.start();
        Seller s1 = new Seller();
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s1);
        Thread t3 = new Thread(s1);
        t1.setName("1号窗口");
        t2.setName("2号窗口");
        t3.setName("3号窗口");
        t1.start();
        t2.start();
        t3.start();
        //线程不安全！！！
    }
}

class MyThread implements Runnable{
    public MyThread() {
        super();
    }

    @Override
    public void run() {
        while(true){
            System.out.println("Hello,filwsx!");
        }
    }
}

class Seller implements Runnable{
    private int ticket = 100;   //因为只需要创建一个对象，传入到多个线程对象之中，所以并不需要static修饰
    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName() + "卖的，票号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
