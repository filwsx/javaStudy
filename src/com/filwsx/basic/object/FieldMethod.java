package com.filwsx.basic.object;

public class FieldMethod {
	public static void main(String args[]) {
		Base b = new Base();
		Sub s = new Sub();
		Base bs = new Sub();
		
		b.display();
		s.display();
		bs.display();
		Sub sb = (Sub)bs;
		sb.display();
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