package com.filwsx.basic.fieldMethod;

public class Geometric {
	protected String color;
	
	public Geometric() {
		
	}
	
	public Geometric(String color) {
		super();
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public double findArea() {
		System.out.println("抽象父类不具有面积特性");
		return 0.0;
	}
}
