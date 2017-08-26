package com.wk.stack;

import java.util.Stack;


/*
 * 需求：使用递归实现一个栈的逆序
 * 
 */
public class Test3 {
	
	
	
	public static void main(String[] args) {
		Stack<Integer> num = new Stack<Integer>();
		num.push(1);
		num.push(2);
		num.push(3);
	
		
		reverse(num);
		System.out.println(num.pop());
		/*while(!num.isEmpty()){
			System.out.println(num.pop());
		}*/
	}
	
	//将栈的栈底元素返回并移除
	public static int getAndRemoveLast(Stack<Integer> num){ 
		int result = num.pop();
		if(num.isEmpty())
			return result;
		else{
			int last = getAndRemoveLast(num);
			num.push(result);
			return last;
		}
	}
	
	//将栈中元素逆转
	
	public static void reverse(Stack<Integer> num){
		if(num.isEmpty()){
			return;
		}
		int result = getAndRemoveLast(num);
		reverse(num);
		num.push(result);
	}
}
