package com.filwsx.basic.object;

public class PayrollSystem {

	public static void main(String[] args) {
		Employee e[] = new Employee[2];
		e[0] = new SalariedEmployee();
		e[1] = new HourlyEmployee();
	}

}
