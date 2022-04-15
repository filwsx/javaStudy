package com.filwsx.JavaStudyAdvanced.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 使用线程池创建多线程
 * @author filwsx
 * @date 2022-02-02 22:22
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        //4.设置线程池的属性
        //System.out.println(service.getClass());
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //service1.setCorePoolSize(15);
        //service1.setKeepAliveTime();

        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new Thread1());
        service.execute(new Thread2());
        //service.submit(Callable callable);//适合使用于Callable

        //3.关闭连接池
        service.shutdown();
    }
}

class Thread1 implements Runnable{
    @Override
    public void run() {

    }
}

class Thread2 implements Runnable{
    @Override
    public void run() {

    }
}