package com.filwsx.thread;

/**
 * @author filwsx
 * @date 2022-02-02 17:55
 */
public class BankThreadTest {
    public static void main(String[] args) {
        new Thread(new SaveMoneyTest()).start();
        new Thread(new SaveMoneyTest()).start();
    }
}

class SaveMoneyTest implements Runnable{
    @Override
    public void run() {
        account a = new account();
        for(int i = 0; i<3; i++){
            a.saveMoney(1000);
            //a.show();
        }
    }
}

class account{
    private static int balance = 0;

    public synchronized void saveMoney(int amount){
        if(amount>0){
            balance += amount;
        }
        System.out.println("余额为："+balance);
    }

    public synchronized void show(){
        System.out.println("余额为："+balance);
    }
}
