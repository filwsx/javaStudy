package com.filwsx.basic.fieldMethod;

/**
 * 
 * @author filwsx
 *
 */
public class FieldMethodTest {
	public static void main(String args[]) {
		/**
		 * 测试多态的方法和属性 2022-01-21 1637
		 */
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
		
		/**
		 * 测试多态的动态调用
		 */
		method(new Person());
		method(new Student());
		method(new Graduate());
		
		Circle c1 = new Circle(5.0,"blue") ;
		Rectangle r1 = new Rectangle(10,20,"red");
		displayGeometric(c1);
		displayGeometric(r1);
		
	}
	
	public static void method(Person e) {
		String info = e.getInfo();
		System.out.println(info);
		System.out.println("**************");
	}
	
	//获取子类的面积
	public static void displayGeometric(Geometric g) {
		System.out.println("面积为：" + g.findArea());
	}
	
	//比较两个面积是否相等
	public static boolean equalsArea(Geometric g1,Geometric g2) {
		return g1.findArea() == g2.findArea();
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