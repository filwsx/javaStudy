package com.filwsx.array;

/**
 * 
 * @author filwsx
 * @Date 18-01-2022 1908done，代码丢失重新写了一遍.
 * 
 */
public class Yanghui {
	
	//输出杨辉三角
	public static void main (String args[]) {
		int end = 10;
		int array[][] = new int[end][];
		for(int i = 0; i < array.length; i++) {
			array[i] = new int[i+1];
			array[i][0] = 1;
			array[i][i] = 1;
			for(int j = 0; j < array[i].length; j++) {
				if(j<array[i].length-1 && j > 0) {
					array[i][j] = array[i-1][j-1] + array[i-1][j];
				}
				System.out.print(array[i][j] + " , ");
			}
			System.out.println();
		}
	}
}
