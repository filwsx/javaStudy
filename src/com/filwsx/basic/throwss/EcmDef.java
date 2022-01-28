package com.filwsx.basic.throwss;

public class EcmDef {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		double result = 0;
		try {
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
			if (a<0 || b<0) {
				throw new EcmDefException("输入值不得为负");
			}
			result = a/(double)b;
		}catch(NumberFormatException e){
			System.out.println("输入内容非数字");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("参数不完整");
		}catch(ArithmeticException e){
			System.out.println("除数为0");
		}catch(EcmDefException e){
			System.out.println(e.getMessage());
		}finally {
			System.out.println("结果为"+result);
		}

	}

}
