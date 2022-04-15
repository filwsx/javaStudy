package com.filwsx.basic.array;

/**
 * 
 * @author filwsx
 * @Date 18-01-2022 2030done，代码丢失重新写了一遍，自己糊涂把middle算错导致死循环，耽误我看真的死循环-电视剧《开端》.
 * 
 */
public class ArrayReverse {
	public static void main (String args[]) {
		int len = 11;
		int array[] = new int[len] ;
		int dist = 0;
		arrayInit(array);
		arrayReverse(array); 
		arrayPrint(array);
		dist = array[4];
		arraySort(array);
		arrayPrint(array);
		System.out.println(dist);
		arraySearch(array,dist);
	}
	
	//数组初始化，随机赋值，100以内
	public static void arrayInit(int array[]) {
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() *100);
			System.out.print(array[i] + " , ");
		}
		System.out.println();
	}
	
	//数组反序
	public static void arrayReverse(int array[]) {
		int len = array.length;
		int temp = 0;
		int end = 0;
		for(int i = 0; i < len/2; i++) {
			end = len - i - 1;
			temp = array[i];
			array[i] = array[end];
			array[end] = temp;
		}
	}
	
	//数组由小到大排列，冒泡排序
	public static void arraySort(int array[]) {
		for(int j =0;j<array.length;j++) {
			for(int i = 0; i < array.length-1-j; i++) {
				if(array [i]>array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
	}
	
	//打印数组内容
	public static void arrayPrint(int array[]) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " , ");
		}
		System.out.println();
	}
	
	//折半搜索
	public static void arraySearch(int array[],int dist) {
		int minIndex = 0;
		int maxIndex = array.length - 1;
		int middleIndex;
		while(true) {
			middleIndex = (maxIndex + minIndex) / 2;
			if( middleIndex>maxIndex || middleIndex<minIndex) {
				System.out.print("Cant find it.");
				break;
			}
			if(array[middleIndex] == dist) {
				System.out.print("I find it!,the index is" + middleIndex);
				break;
			}else if(array[middleIndex] > dist) {
				maxIndex = middleIndex - 1;
			}else {
				minIndex = middleIndex + 1;
			}

		}
	}
}
