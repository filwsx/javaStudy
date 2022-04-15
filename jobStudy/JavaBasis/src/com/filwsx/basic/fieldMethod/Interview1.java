package com.filwsx.basic.fieldMethod;

public class Interview1 {

	public static void main(String[] args) {
		Base1 base1 = new Sub1();
		base1.add(1, 2, 3);

		Sub1 s = (Sub1)base1;
		s.add(1,2,3);
	}
}

class Base1 {
	//可变形参本质是数组
	public void add(int a, int... arr) {
		System.out.println("base");
	}
}

class Sub1 extends Base1 {

	@Override
	public void add(int a, int[] arr) {
		System.out.println("sub_1");
	}

	//重载优先调用参数确定的
	public void add(int a, int b, int c) {
		System.out.println("sub_2");
	}

}
