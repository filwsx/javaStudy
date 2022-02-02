package com.filwsx.basic.interfacee;

public class MP3 implements USB{

	@Override
	public void start() {
		System.out.println("mp3设备连接成功");
		
	}

	@Override
	public void run() {
		System.out.println("mp3设备工作中...");
		
	}

	@Override
	public void stop() {
		System.out.println("mp3设备已断开");
		
	}

}
