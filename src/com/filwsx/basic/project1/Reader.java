package com.filwsx.basic.project1;

import java.util.Scanner;

/**
 * 
 * @author filwsx
 * @describe 基于尚硅谷的utility结构而成，重写了部分逻辑。
 *
 */
public class Reader {
	
	private static Scanner scanner = new Scanner(System.in);
	
    /**
	用于从键盘读取一行，并且限制输入长度。返回值为用户输入的字符串。
	*/
	private static String readKeyBoard(int limit) {
		String line = "";
		while(true) {
			line = scanner.nextLine();
			if(line.length() < 1 || line.length() > limit) {
				System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
			}else {
				return line;
			}
		}
	}
	
    /**
	用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’3’中的任意字符，则方法返回对应int值。否则从新输入。
	*/
	public static int readMenuSelection() {
		char c;
		while(true) {
			String str = readKeyBoard(1);
			c = str.charAt(0);
			switch (c) {
				case '1': return 1;
				case '2': return 2;
				case '3': return 3;
				default: System.out.print("输入错误，请重新输入：");
			}
		}
	}
	
	/**
	用于收入和支出金额的输入。该方法从键盘读取一个不超过4位长度的整数，并将其作为方法的返回值。
	*/
	public static int readNumber() {
		int n;
		while(true) {
			String str = readKeyBoard(4);
            try {
                n = Integer.parseInt(str);
                return n;
            } catch (NumberFormatException e) {
                System.out.print("输入错误，请重新输入：");
            }
		}
	}
	
	/**
	用于收入和支出说明的输入。该方法从键盘读取一个不超过8位长度的字符串，并将其作为方法的返回值。
	*/
    public static String readString() {
        String str = readKeyBoard(8);
        return str;
    }
    
    /**
	用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
	*/
    public static boolean readConfirmSelection() {
        char c;
        while(true){
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            switch(c) {
            	case 'Y': return false;
            	case 'N': return true;
            	default: System.out.print("选择错误，请重新输入：");
            }
        }
    }
}
