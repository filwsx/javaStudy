package com.filwsx.basic.fieldMethod;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geometric other = (Geometric) obj;
		return Objects.equals(color, other.color);
	}
	
	
}
