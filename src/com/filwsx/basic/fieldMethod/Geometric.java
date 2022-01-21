package com.filwsx.basic.fieldMethod;

public class Geometric {
	protected String color;
	protected double weight;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Geometric(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	
}
