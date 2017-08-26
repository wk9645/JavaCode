package com.wk.test;

class SuperClass {
	
	
	/*public static String str1 = "abc";
	public String str2 = "edf";
	
	
	static{
		System.out.println("父类静态代码块");
	}
	
	
	{
		System.out.println("父类非静态代码块");
	}
	
	public SuperClass() {
		System.out.println("父类构造方法");
	}
	
	
	
	public static void testStatic(){
			
		System.out.println("父类静态方法");
	}
	*/
	
	public void test(){
		System.out.println("父类非静态方法");
	}
}





public class SubClass extends SuperClass{
	
	/*public static String str1 = "123";
	public String str2 = "456";
	
	static{
		System.out.println("子类静态代码块");
	}
	
	{
		System.out.println("子类非静态代码块");
	}
	
	public SubClass() {
		System.out.println("子类构造方法");
	}
	
	public static void testStatic(){
		System.out.println("子类静态方法");
	}
	*/
	@Override
	public void test(){
		
		System.out.println(super.getClass().getName());
		System.out.println("子类非静态方法");
	}
	
	public static void main(String[] args) {
		new SubClass().test();
	}
	
}


