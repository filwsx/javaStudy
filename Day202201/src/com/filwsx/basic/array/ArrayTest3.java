package com.filwsx.basic.array;

/**
 * 
 * @author filwsx
 * @Date 18-01-2022 2336done method1.
 * 
 */
public class ArrayTest3 {
	public static void main (String args[]) {
		int init = 6;
		int arraytest[][] = new int[init][init];
		method1(arraytest);
		arrayPrint(arraytest);
	}
	
	public static void method2(int array[][]) {
		//目前不会，放弃。2022-01-18 2349
		//本项目到目前为止，代码全为自己写的，除了冒泡排序看了一下动画演示。
	}
	
	//产生一个n*n的二维数组，使用1-n^2去填充，填充规律为蛇形盘旋，由外到内绕圈。
	public static void method1(int array[][]) {
		int init = array.length;
		int maxVaule = init * init;
		int max=init,min=0;
		int flag = 1;
		int mod = 1;	//mod有4种值。mod=1时j++,mod=2时i++,mod=3时j--,mod=4时i--.状态机
		int i = 0, j = 0;
		while(flag <= maxVaule) {
			array[i][j]=flag;
			flag++;
			if(mod==1) {
				//判断是否到达边界
				if((j+1)==max) {
					mod = 2;
				}else {
					j++;
				}
			}
			if(mod==2) {
				if((i+1)==max) {
					mod = 3;
				}else {
					i++;
				}
			}
			if(mod==3) {
				if((j-1)==min-1) {
					mod = 4;
				}else {
					j--;
				}
			}
			if(mod==4) {
				if((i-1)==min) {
					mod = 1;
					max--;
					min++;
					i = min;
					j = min;
				}else {
					i--;
				}
			}
		}
	}
	
	public static void arrayPrint(int array[][]) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
}