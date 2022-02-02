package com.filwsx.basic.project1;

public class Menu {
	static int key;
	static String details = "收支金额\t账户余额\t说    明\n";
	static int balance = 10000;
	static boolean flag = true;
	public static void main(String args[]) {
		while(flag) {
			showMenu();
			switch (key) {
				case 1: detail();break;
				case 2: change();break;
				case 3: exit();break;
			}
		}

	}
	
	public static void showMenu() {
		System.out.println("\n-----------------家庭收支记账软件-----------------\n");
        System.out.println("                   1 收支明细");
        System.out.println("                   2 登记收支");
        System.out.println("                   3 退    出\n");
        System.out.print("                   请选择(1-3)：");
        key = Reader.readMenuSelection();
        System.out.println();
	}
	
	public static void detail() {
        System.out.println("-----------------当前收支明细记录-----------------");
        System.out.println(details);
        System.out.println("--------------------------------------------------");
	}
	
	public static void change() {
        System.out.print("本次收支金额：");
        int amount1 = Reader.readNumber();
        System.out.print("本次收支说明：");
        String desc1 = Reader.readString();
        balance += amount1;
        details += amount1 +"\t" + balance + "\t\t" + desc1 + "\n";
        System.out.println("---------------------登记完成---------------------");
	}
	
	public static void exit() {
		System.out.print("确认是否退出(Y/N)：");
        flag = Reader.readConfirmSelection();
	}

}
