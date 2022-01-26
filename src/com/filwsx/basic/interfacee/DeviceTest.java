package com.filwsx.basic.interfacee;

public class DeviceTest {
	public static void main(String args[]) {
		Computer d1 = new Computer();
		MP3 d2 = new MP3();
		d1.transferData(d2);
	}
}

class Computer{
	public void transferData(USB usb) {
		usb.start();
		usb.run();
		usb.stop();
	}
}