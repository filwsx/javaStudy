package com.filwsx.basic.object;

public class SalariedEmployee extends Employee {
	private int monthlySalary;
	@Override
	public int earnings() {
		return monthlySalary;
		// TODO Auto-generated method stub
	}

	public String toString() {
		return "SalariedEmployee" + super.toString();
	}

	public int getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public SalariedEmployee() {
		super();
	}
	public SalariedEmployee(int monthlySalary) {
		this();
		this.monthlySalary = monthlySalary;
	}
	
}
