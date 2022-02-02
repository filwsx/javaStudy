package com.filwsx.basic.interfacee;

//代理的设计模式，测试
public class NetworkTest {
	public static void main(String args[]) {
		Server s = new Server();
		ProxyServer p = new ProxyServer(s);
		p.browse();
	}
}

interface Network {
	public void browse();
}

//被代理类
class Server implements Network{

	@Override
	public void browse() {
		System.out.println("开始访问网络");
	}
	
}

//代理类
class ProxyServer implements Network{
	private Network nw;
	public void check() {
		System.out.println("联网前的检查");
	}
	
	public ProxyServer(Network nw) {
		this.nw = nw;
	}

	@Override
	public void browse() {
		check();
		nw.browse();
	}
}