package com.filwsx.basic.object;

public class Student extends Person{
	protected int number;
	protected int state;
	protected int score;
	protected String school="pku";
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getInfo() {
		return "Name: "+ name + "\nage: "+ age + "\nschool: "+ school;
	}

	
}
