package com.filwsx.basic.object;

public class CheckAccount extends Account{
	private double overdraft;
	
	public CheckAccount() {
		
	}
	public CheckAccount(int id, double balance, double annualInterestRate,double overdraft) {
		super(id,balance,annualInterestRate);
		this.overdraft = overdraft;
	}
	
	@Override
	public void withdraw (double amount){
		if(balance + overdraft >= amount) {
			if(balance>=amount) {
				balance -= amount;
			}else {
				overdraft += (balance-amount);
				balance = 0;
			}
			System.out.println("存款剩余："+balance);
			System.out.println("透支额度剩余："+overdraft);
		}else {
			System.out.println("透支额度不够");
		}
	}
}
