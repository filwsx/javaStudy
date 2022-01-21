package com.filwsx.basic.object;

public class Account {
	private int id;
	protected double balance;
	private double annualInterestRate;
	
	public Account() {
		
	}
	
	public Account (int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance  = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	public int getId(){
		return id;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	public void setAnnualInterestRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}
	
	public double getMonthlyInterest() {
		return annualInterestRate;
		
	}

	//取钱
	public void withdraw (double amount){
		if(this.balance>= amount) {
			this.balance -= amount;
		}else {
			System.out.println("余额不足");
		}
	}
	
	//存钱
	public void deposit (double amount){
		if(amount>0) {
			this.balance += amount;
		}
	}

}
