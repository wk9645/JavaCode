package com.wk.test;

class SuperClass {
	
	
	/*public static String str1 = "abc";
	public String str2 = "edf";
	
	
	static{
		System.out.println("���ྲ̬�����");
	}
	
	
	{
		System.out.println("����Ǿ�̬�����");
	}
	
	public SuperClass() {
		System.out.println("���๹�췽��");
	}
	
	
	
	public static void testStatic(){
			
		System.out.println("���ྲ̬����");
	}
	*/
	
	public void test(){
		System.out.println("����Ǿ�̬����");
	}
}





public class SubClass extends SuperClass{
	
	/*public static String str1 = "123";
	public String str2 = "456";
	
	static{
		System.out.println("���ྲ̬�����");
	}
	
	{
		System.out.println("����Ǿ�̬�����");
	}
	
	public SubClass() {
		System.out.println("���๹�췽��");
	}
	
	public static void testStatic(){
		System.out.println("���ྲ̬����");
	}
	*/
	@Override
	public void test(){
		
		System.out.println(super.getClass().getName());
		System.out.println("����Ǿ�̬����");
	}
	
	public static void main(String[] args) {
		new SubClass().test();
	}
	
}


