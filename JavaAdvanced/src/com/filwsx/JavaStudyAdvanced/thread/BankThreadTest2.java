package com.filwsx.JavaStudyAdvanced.thread;

/**
 * @author filwsx
 * @date 2022-02-02 18:32
 */
public class BankThreadTest2 {
    public static void main(String[] args) {
        //这样写就不是两个账户再存，而是一个账户同时两个操作
        Account2 a1 = new Account2();
        new Thread(a1).start();
        new Thread(a1).start();
        //这说明New两个Account2时，线程同步锁其实是两个！
        //下边代码验证了我的上述猜想！！
        new Thread(new Account2()).start();
        new Thread(new Account2()).start();
        //此例理解了static和非static方法的同步锁不同！！！，光记笔记没用，得踩坑，1856写
    }
}

class Account2 implements Runnable{
    private static double balance = 0;

    public synchronized static void saveMoney(int amount){
        if(amount>0){
            balance += amount;
        }
        System.out.println("余额为："+balance);
    }

    @Override
    public void run() {
        for(int i = 0; i<3; i++){
            saveMoney(1000);
        }
    }
}
