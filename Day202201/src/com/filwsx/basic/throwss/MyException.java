package com.filwsx.basic.throwss;

public class MyException extends Exception {
	static final long serialVersionUID = -19890604L;
	public MyException() {
		
	}
	public MyException(String msg) {
		super(msg);
	}
}
