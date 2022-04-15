package com.filwsx.basic.object;

import java.util.Calendar;

public class PayrollSystem {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);//获取当前的月份
		Employee e[] = new Employee[2];
		e[0] = new SalariedEmployee("filw", 1002,new MyDate(2002, 1, 26),15000);
		e[1] = new HourlyEmployee("sx", 2002, new MyDate(2001, 7, 6),60,260);
		for(int i = 0;i < e.length;i++){
			System.out.println(e[i]);
			double salary = e[i].earnings();
			System.out.println("月工资为：" + salary);
			
			if((month+1) == e[i].getBirthday().getMonth()){
				System.out.println("生日快乐！奖励100元");
			}
			
		}
	}

}
