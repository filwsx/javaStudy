package com.filwsx.basic.object;

import java.util.Calendar;

public class PayrollSystem {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);//获取当前的月份
		Employee e[] = new Employee[2];
		e[0] = new SalariedEmployee("马森", 1002,new MyDate(1992, 2, 28),10000);
		e[1] = new HourlyEmployee("潘雨生", 2001, new MyDate(1991, 1, 6),60,240);
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
