package com.filwsx.JavaStudyAdvanced.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**使用Callable的实现来创建多线程
 * @author filwsx
 * @date 2022-02-02 21:49
 */
public class CallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i%2==0){
                sum += i;
            }
        }
        return sum;
    }
}

class CallableThread{
    public static void main(String[] args) {
        CallableTest ct = new CallableTest();
        FutureTask ft = new FutureTask(ct);
        new Thread(ft).start();
        Object sum = null;
        try {
            sum = ft.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}