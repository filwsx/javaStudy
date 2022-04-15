package com.filwsx.basic.object;

public class CheckAccount extends Account{
	private double overdraft;
	
	public static void main(String args[]) {
		//CheckAccountTest();
		//GraduateTest();
	}
	public static void CheckAccountTest() {
		CheckAccount ca1 = new CheckAccount(1122,20000,4.5,5000);
		ca1.withdraw(5000);
		ca1.withdraw(18000);
		ca1.withdraw(3000);
	}
	
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
