package com.filwsx.basic.object;

public class HourlyEmployee extends Employee {
	private int wage,hour;
	@Override
	public int earnings() {
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
	
	public HourlyEmployee() {
		super();
	}
	
	public HourlyEmployee(int wage, int hour) {
		this();
		this.wage = wage;
		this.hour = hour;
	}
	
}
