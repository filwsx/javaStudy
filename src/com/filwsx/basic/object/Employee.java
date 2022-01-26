package com.filwsx.basic.object;

abstract public class Employee {
	private String name;
	private int number;
	private MyDate birthday;
	public abstract double earnings();
	public String toString() {
		return "，name=" + name + "，number=" + number + "，birthday=" + birthday.toDateString();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	
	public Employee() {
		super();
	}
	
	public Employee(String name, int number, MyDate birthday) {
		this();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}
	
}
