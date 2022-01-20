package com.filwsx.array;

/**
 * 
 * @author filwsx
 * @Date 18-01-2022 1919done，代码丢失重新写了一遍.
 * 
 */
public class ArrayTest {
	//数组遍历，寻找最值、平均，求和
	public static void main (String args[]) {
		int end = 10;
		int array[] = new int[end];
		int max,min;
		int sum = 0;
		double avarage = 0.0;
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() *100);
			System.out.print(array[i] + " , ");
		}
		System.out.println();
		min = array[0];
		max = array[0];
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			if(array[i] > max) {
				max = array[i];
			}
			if(array[i] < min) {
				min = array[i];
			}
		}
		avarage = (double)sum/array.length;
		System.out.println("最大值为：" + max);
		System.out.println("最小值为：" + min);
		System.out.println("平均值为：" + avarage);
		System.out.println("总和为：" + sum);
	}
}