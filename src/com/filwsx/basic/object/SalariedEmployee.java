package com.filwsx.basic.object;

public class SalariedEmployee extends Employee {
	private double monthlySalary;
	@Override
	public double earnings() {
		return monthlySalary;
		// TODO Auto-generated method stub
	}

	public String toString() {
		return "SalariedEmployee" + super.toString();
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public SalariedEmployee(String name, int number, MyDate birthday,double monthlySalary) {
		super(name, number, birthday);
		this.monthlySalary = monthlySalary;
	}
	
}
