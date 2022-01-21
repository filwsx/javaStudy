package com.filwsx.basic.fieldMethod;

public class Circle extends Geometric{
	private double radius;

	public Circle() {
		super();
	}

	public Circle(double radius , String color) {
		super(color);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double findArea() {
		return radius*radius*Math.PI;
	}
}
