package com.filwsx.basic.object;

public class Test {
	public static void main(String args[]) {
		CheckAccount ca1 = new CheckAccount(1122,20000,4.5,5000);
		ca1.withdraw(5000);
		ca1.withdraw(18000);
		ca1.withdraw(3000);
	}
}
