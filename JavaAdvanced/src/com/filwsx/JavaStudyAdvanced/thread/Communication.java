package com.filwsx.JavaStudyAdvanced.thread;

/**
 * 多线程之间的通信问题：实际就是几个方法和共享数据
 * @author filwsx
 * @date 2022-02-02 20:56
 */
public class Communication {
    public static void main(String[] args) {
        Product pp = new Product();
        Producer p1 = new Producer(pp);
        Consumer c1 = new Consumer(pp);
        p1.setName("生产者1");
        c1.setName("消费者1");
        p1.start();
        c1.start();
    }
}

class Product{
    private int productCount = 0;

    public synchronized void consumerProduct() {
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+"消费第"+productCount+"个产品");
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void producerProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"生产第"+productCount+"个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Product pp = null;
    public Producer(Product pp){
        this.pp = pp;
    }
    @Override
    public void run() {
        super.run();
        for(;;){
            pp.producerProduct();
        }
    }
}

class Consumer extends Thread{
    private Product pp = null;
    public Consumer(Product pp){
        this.pp = pp;
    }
    @Override
    public void run() {
        super.run();
        for (;;){
            pp.consumerProduct();
        }
    }
}