package com.filwsx.basic.fieldMethod;

public class Rectangle extends Geometric {
	private double width;
	private double height;
	
	public Rectangle() {
		super();
	}
	public Rectangle(double width, double height, String color) {
		super(color);
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double findArea() {
		return width*height;
	}
}
