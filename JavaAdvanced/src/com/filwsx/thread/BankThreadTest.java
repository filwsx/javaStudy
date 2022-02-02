package com.filwsx.thread;

/**
 * @author filwsx
 * @date 2022-02-02 17:55
 */
public class BankThreadTest {
    public static void main(String[] args) {
        new Thread(new account()).start();
        new Thread(new account()).start();
    }
}

class account implements Runnable{
    private static int balance = 0;

    public synchronized void saveMoney(int amount){
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
