package com.filwsx.basic.exercise;

public class LogicExercise {
	public static void main(String args[]) {
		boolean b1 = true;
		boolean b2 = false;
		int num1 = 1;
		int num2 = 0;
		if (b1 & (++num2 > 0)) {
			System.out.println("test1");
		}
		System.out.println("num2是" + num2);
		num2 = 0;
		if (b1 & (num2++ > 0)) {
			System.out.println("test2");
		}
		System.out.println("num2是" + num2);
		num2 = 0;
		if (b2 && (num2++ > 0)){
			System.out.println("test3");
		}
		System.out.println("num2是" + num2);
		num2 = 0;
		if (b1 && (++num1 > 0)){
			System.out.println("test4");
		}
		System.out.println("num2是" + num2);
	}
}
