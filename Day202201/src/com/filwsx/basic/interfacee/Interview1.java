package com.filwsx.basic.interfacee;

public class Interview1 extends B implements A{
	public static void main(String args[]) {
		B test = new B();
		System.out.println(test.x);
		System.out.println(A.x);
	}
}

interface A{
	int x = 0;
}

class B{
	int x = 1;
}