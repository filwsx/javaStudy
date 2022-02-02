package com.filwsx.thread;

/**
 * @author filwsx
 * @date 2022-02-02 17:55
 */
public class BankThreadTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        new Thread(new Customer(account)).start();
        new Thread(new Customer(account)).start();
    }
}

//使用视频里的方法重构代码,这下打印的余额信息正常了，为什么？？18：30写
class Customer implements Runnable{
    private Account acct;

    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {
        for(int i = 0; i<3; i++){
            acct.saveMoney(1000);
        }
    }
}

class Account{
    private double balance = 0;

    public Account(double balance){
        this.balance = balance;
    }
    public synchronized void saveMoney(int amount){
        if(amount>0){
            balance += amount;
        }
        System.out.println("余额为："+balance);
    }
}
