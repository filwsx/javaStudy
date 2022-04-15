package com.filwsx.basic.object;

public class MoFish {
	public static void main(String args[]) {
		System.out.println("这是一个摸鱼的类");
		MoFish my = MoFish.getMoFish();
		my.method();
	}
	
	private MoFish() {
		
	}
	
	private static MoFish moyu = new  MoFish();
	
	public static MoFish getMoFish() {
		return moyu;
	}
	
	public void method() {
		System.out.println("饿汉式单例摸鱼");
		System.out.println("为了刷github活跃度");
	}
}
