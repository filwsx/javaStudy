package com.filwsx.project2;

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
    
    /**
	用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’5’中的任意字符，则方法返回对应int值。否则从新输入。
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
				case '4': return 4;
				case '5': return 5;
				default: System.out.print("输入错误，请重新输入：");
			}
		}
	}
	
	/**
	用于年龄输入。该方法从键盘读取一个不超过3位长度的整数，判断范围合理后将其返回。
	*/
	public static int readAge() {
		int n;
		while(true) {
			String str = readKeyBoard(3);
            try {
                n = Integer.parseInt(str);
                if(n > 0 && n < 150) {
                	return n;
                }else {
                	System.out.print("年龄输入超出正常范围");
                }
            } catch (NumberFormatException e) {
                System.out.print("输入错误，请重新输入：");
            }
		}
	}
	
	public static int readInt(int len) {
		int n;
		while(true) {
			String str = readKeyBoard(len);
            try {
                n = Integer.parseInt(str);
                return n;
            } catch (NumberFormatException e) {
                System.out.print("输入错误，请重新输入：");
            }
		}
	}
	
	
	
	/**
	用于字符串类型的信息输入。该方法从键盘读取一个不超过20位长度的字符串，并将其作为方法的返回值。
	*/
    public static String readString(int len) {
        return readKeyBoard(len);
    }
    
    /**
	用于字符类型的信息输入。该方法从键盘读取一个字符，并将其作为方法的返回值。
	*/
    public static char readChar() {
        String str = readKeyBoard(1).toUpperCase();
        char c = str.charAt(0);
        return c;
    }
}
