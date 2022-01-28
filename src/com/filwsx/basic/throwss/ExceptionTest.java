package com.filwsx.basic.throwss;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

public class ExceptionTest {
	
	@Test
	public void Test() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	@Test
	public void NullPointerExceptionTest() {
		int arr[] = null;
		System.out.print(arr[0]);
	}
	
	@Test
	public void ArrayIndexOutOfBoundsExceptionTest() {
		String str = "abc";
		str = null;
		System.out.print(str.charAt(0));
	}
	
	@Test
	public void ClassCastExceptionTest() {
		Object obj = new Date();
		String str = (String) obj;
	}
	
	@Test
	public void NumberFormatExceptionTest() {
		String str = "123";
		str = "abc";
		int num = Integer.parseInt(str);
		System.out.print(num);
	}
	
	@Test
	public void InputMismatchExceptionTest() {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		System.out.print(score);
	}
	
	@Test
	public void ArithmeticExceptionTest() {
		int a = 10;
		int b = 0;
		System.out.print(a/b);
	}
}
