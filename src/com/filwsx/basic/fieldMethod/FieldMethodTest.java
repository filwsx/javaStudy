package com.filwsx.basic.fieldMethod;

/**
 * 
 * @author filwsx
 * @describe 测试多态的方法和属性 2022-01-21 1637
 *
 */
public class FieldMethodTest {
	public static void main(String args[]) {
		//Base b = new Base();
		//Sub s = new Sub();
		Base bs = new Sub();
		
		//b.display();
		//s.display();
		
		bs.display();
		System.out.println("这是Sub()构造的Base类" + bs.count);
		Sub sb = (Sub)bs;
		sb.display();
		System.out.println("这是转为Sub类的Base类" + sb.count);
		
		method(new Person());
		method(new Student());
		method(new Graduate());
		
	}
	
	public static void method(Person e) {
		String info = e.getInfo();
		System.out.println(info);
		System.out.println("**************");
	}
	
	
}

class Base{
	int count = 10 ;
	public void display() {
		System.out.println("这是父类" + this.count);
	}
}

class Sub extends Base{
	int count = 20 ;
	public void display() {
		//super.display();
		System.out.println("这是子类" + this.count);
	}
}