package com.filwsx.basic.throwss;

import org.junit.Test;

public class ErrorTest {
	public static void main(String args[]) {
	}
	
	@Test
	public void StackOverflowError() {
		//StackOverflowError
		StackOverflowError();
	}
	
	@Test
	public void OutOfMemoryErrorTest() {
		//OOM:OutOfMemoryError
		Integer arr[] = new Integer[1024*1024*1024];
	}
}
