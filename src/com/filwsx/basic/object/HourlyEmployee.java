package com.filwsx.basic.object;

public class HourlyEmployee extends Employee {
	private int wage,hour;
	@Override
	public double earnings() {
		return wage*hour;
	}
	public String toString() {
		return "HourlyEmployee" + super.toString();
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public HourlyEmployee(String name, int number, MyDate birthday,int wage, int hour) {
		super(name, number, birthday);;
		this.wage = wage;
		this.hour = hour;
	}
	
}
