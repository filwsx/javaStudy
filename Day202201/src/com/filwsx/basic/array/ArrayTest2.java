package com.filwsx.basic.array;

/**
 * 
 * @author filwsx
 * @Date 18-01-2022 2258done 每次循环，注意初始条件是否需要手动初始化.
 * 
 */
public class ArrayTest2 {
	//生成长度为len的数组，数组元素为0-99随机整数，数组元素不重复
	public static void main (String args[]) {
		//int len = 101; //这么写，如果算法正确，则会陷入死循环
		int len = 6;
		int array[] = new int[len];
		for(int i = 0; i < array.length; i++) {
			int flag = 0;
			while(flag < i) {
				flag = 0;
				array[i] = (int)(Math.random() *100);
				for(int j = 0; j < i; j++) {
					if(array[i] != array[j]) {
						flag++;
					}
				}
			}
			System.out.print(array[i] + " , ");
		}
		System.out.println();
	}
}