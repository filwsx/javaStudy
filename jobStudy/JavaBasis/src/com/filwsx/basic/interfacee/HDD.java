package com.filwsx.basic.interfacee;

public class HDD implements USB{
	@Override
	public void start() {
		System.out.println("HDD设备连接成功");
		
	}

	@Override
	public void run() {
		System.out.println("HDD设备工作中...");
		
	}

	@Override
	public void stop() {
		System.out.println("HDD设备已断开");
		
	}
}
