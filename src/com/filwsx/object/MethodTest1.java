package com.filwsx.object;

/**
 * 
 * @author filwsx
 * @describe 面试题
 *
 */
public class MethodTest1 {
	public static void main(String args[]) {
		int a=10;
		int b=10;
		method(a,b);//编写此方法，使得程序仅输出a=100,b=200
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
	public static void method(int a,int b) {
		System.out.print("a=100,");
		System.out.println("b=200");
		System.exit(0);
	}
	
	//方法2：重写println(),还的学习I/O这部分的知识吧
	
}
