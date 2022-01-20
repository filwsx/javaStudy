package com.filwsx.object;

/**
 * 
 * @author filwsx
 * @describe 递归的应用 20220119 1325done
 * 没有实现：汉诺塔，快排
 *
 */
public class Recursion {
	public static void main(String args[]) {
		System.out.println("1-100的和为" + sum(100));
		System.out.println("10的阶乘为" + factorial(10));
		System.out.println("f1(10)结果为" + f1(10));
		System.out.println("f2(10)结果为" + f2(10));
		System.out.println("斐波那契数列第十个为" + Fibonacci(10));
		
	}
	
	//求1-number内所有正整数之和
	public static int sum(int number) {
		if(number == 1) {
			return 1;
		}else {
			return number + sum(--number);
		}
	}
	
	//求number的阶乘
	public static int factorial(int number) {
		if(number == 1) {
			return 1;
		}else {
			return number * factorial(--number);
		}
	}
	
	//已知有一个数列：f(0) = 1,f(1) = 4,f(n+2)=2*f(n+1) + f(n),其中n是大于0的整数，求f(10)的值。
	public static int f1(int number) {
		if(number == 0) {
			return 1;
		}else if(number == 1){
			return 4;
		}else {
			return 2*f1(number-1) + f1(number-2);
		}
	}
	
	//已知一个数列：f(20) = 1,f(21) = 4,f(n+2) = 2*f(n+1)+f(n),其中n是大于0的整数，求f(10)的值。
	public static int f2(int number) {
		if(number == 20) {
			return 1;
		}else if(number == 21){
			return 4;
		}else {
			return f2(number+2) - 2*f2(number+1);
		}
	}//20220119 1321done
		
	//输入一个数据n，计算斐波那契数列(Fibonacci)的第n个值.规律：一个数等于前两个数之和:1 1 2 3 5 8 13 21 34 55
	public static int Fibonacci(int number) {
		if(number == 1 || number == 2) {
			return 1;
		}else {
			return Fibonacci(number-2) + Fibonacci(number-1);
		}
	}
	
}
