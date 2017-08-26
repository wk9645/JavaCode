package com.niuke;


/*
 *请实现一个函数，将一个字符串中的空格替换成20%
 * 
 *  一、使用StringBuffer
 * 
 * 二、使用正则表达式
 * 
 * 
 */



public class Test2 {
		
	
	public String replace(String str){

		String par = "20%";
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<=str.length()-1;++i){
			if(str.charAt(i) == ' '){
				buffer.append(par);
			}else{
				buffer.append(str.charAt(i));
			}
		}
		return buffer.toString();
	}
	
	
	public static String replaceSpace(String str){
		        String regex = "\\s";
		        str = str.replaceAll(regex,"20%");
		        return str;
	}
	
	
	public static void main(String[] args) {
		
		
		Test2 test = new Test2();
//		String result = test.replace("we are the world");
		String str = replaceSpace("we are the world");
		System.out.println(str);
	}
}	
