package com.wk.test;

import java.util.Date;

public class Gender extends Date{
	
	
	public static void main(String[] args) {
		
		new Gender().test();
		
		
	}

	
	public void test(){
		
		System.out.println(getClass().getSimpleName());
		
	}
	
}
