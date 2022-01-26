package com.filwsx.basic.object;

public class InnerClassTest {
	public static void main(String[] args) {
		Person p = new Person();
		Person.Hung  h = p.new Hung();
		h.breath();
		Person.ear earLeft = new Person.ear();
		earLeft.nothing();
	}
}
interface Lanuage{
	public void word();
}

class Person{
    //非静态成员内部类
    String name = "filwsx";
	class Hung{
		String name = "hung";
		public void breath() {
			System.out.println("肺在呼吸");
            System.out.println(Person.this.name);
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(new Person.eye().name);
            System.out.println(new Person.ear().name);
		}
	}
	class eye{
		String name = "eye";
		public void open() {
			System.out.println("睁开眼");
		}
		public void close() {
			System.out.println("闭上眼");
		}
	}
	//静态成员内部类
	static class ear{
		String name = "ear";
		public void nothing() {
			
		}
	}
	
	public Lanuage getNativeSpeaker() {
		return new Lanuage() {
			public void word() {
				System.out.println("汉语");
			}
		};
	}
	
	public Comparable getComparable(){
		return new Comparable(){
			@Override
			public int compareTo(Object o) {
				return 0;
			}
		};
	}
}
