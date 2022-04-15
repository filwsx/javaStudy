package com.filwsx.basic.throwss;

public class Test {
	public static void main(String args[]) {
		try {
			method();
		}catch(Exception e){
			String msg = e.getMessage();
			System.out.println(msg);
		}finally {
			System.out.println("老子怎么都会运行");
		}
	}
	
	public static void method() throws MyException {
		
		throw new MyException("自己的异常类");
	}

}
