package com.wk.test2;


/*
 *	创建四个线程，分别对变量进行加一和减一
 */

public class MyThread {


	public static void main(String[] args) {
		
		Cal cal = new MyThread().new Cal();
		
		for(int i=0; i<2; i++){
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
//					while(true){
						
						cal.add();
//					}
				}
			}).start();
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
//					while(true){
						
						cal.sub();
//					}
				}
			}).start();
		}
		
	}
	
	
	public class Cal{
	
		int i=0;
		
		public synchronized void add(){
			i++;
			System.out.println(Thread.currentThread().getName()+"加一：" + i);
		}
		
		public synchronized void sub(){
			i--;
			System.out.println(Thread.currentThread().getName() + "减一：" + i);
		}
		
	}
	
}
