package com.filwsx.basic.object;

public class Test {
	public static void main(String args[]) {
		
		//CheckAccountTest();
		//GraduateTest();
		
	}

	public static void GraduateTest() {
		Graduate g = new Graduate();
		System.out.println(g.getInfo());
	}
	
	public static void StudentTest() {
		Student s = new Student();
		System.out.println(s.getInfo());
	}
	
	public static void PersonTest() {
		Person p = new Person();
		System.out.println(p.getInfo());
	}
	
	public static void CheckAccountTest() {
		CheckAccount ca1 = new CheckAccount(1122,20000,4.5,5000);
		ca1.withdraw(5000);
		ca1.withdraw(18000);
		ca1.withdraw(3000);
	}
}
