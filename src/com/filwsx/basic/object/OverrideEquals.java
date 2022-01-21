package com.filwsx.basic.object;

public class OverrideEquals extends Customer{

	public static void main(String args[]) {
		OverrideEquals oe1 = new OverrideEquals("endwo","filwsx");
		OverrideEquals oe2 = new OverrideEquals("endwo","filwsx");
		OverrideEquals oe3 = null;
		boolean flag = oe1.equals(oe2);
		System.out.println("\t对比结果为："+flag);
	}
	
	public OverrideEquals(String f, String l) {
		super(f, l);
	}
	
	@Override
	public boolean equals(Object temp) {
		System.out.println("重写的equals方法:");
		
		if (this == temp) {
			return true;
		}
		
		if (temp == null){
			return false;
		}
		
		if(temp instanceof Customer) {
			Customer c = (Customer)temp;
			return this.getFirstName() == c.getFirstName() && this.getLastName() == c.getLastName();
		}else {
			return false;
		}
	}
}
