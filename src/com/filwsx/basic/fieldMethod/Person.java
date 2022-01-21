package com.filwsx.basic.fieldMethod;


public class Person {
	protected String name = "张三";
	protected int age = 35; //中年危机，面临裁员，碰上疫情
	protected int sex;
	
//	public static void main(String args[]) {
//		Person p1 = new Person("李四",16,1);
//		Person p2 = new Person();
//		p2.setName("张三");
//		p2.setAge(19);
//		p2.setSex(1);
//		p1.addAge();
//		p2.study();
//	}
	
	Person(){
		
	}
	
	Person(String name,int age,int sex){
		this.age = age;
		this.name = name;
		this.sex = sex;
	}
	public void study() {
		System.out.println(name + "正在学习");
	}
	
	public void showAge() {
		System.out.println(name + "已经" + age + "岁啦");
	}
	
	public void addAge() {
		age++;
		System.out.println(name + "又长大一岁啦");
	}
	
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
		System.out.println("年龄设置成功");
	}
	
	public int getSex() {
		return this.sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
		System.out.println("性别设置成功");
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("姓名设置成功");
	}
	
	public String getInfo() {
		return "Name: "+ name + "\n" +"age: "+ age;
	}

}
