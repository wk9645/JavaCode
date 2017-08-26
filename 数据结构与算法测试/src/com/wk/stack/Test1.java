package com.wk.stack;
import java.util.Stack;

/*
 * 问题：实现一个特殊的栈，在实现栈的基本功能上，再实现返回栈中最小元素的功能
 * 
 * 
 * 思路：使用两个栈，一个用来保存当前栈的元素，记为stackData；
 * 				另一个栈用来保存每一步的最小值，记为stackMin
 * 		方案一、
 * 			1、压入规则：
 * 					（1）假设数据为newData，现将其压入stackData中，然后判断stackMin中是否为空
 * 					（2）如果为空，则newData直接压入stackMin中
 * 					（3）如果不为空，比较newData和stackMin的栈顶值，
 * 						如果为不大于，则newData也压入stackMin中，否则不进行压入
 * 
 * 			2、弹出规则：
 * 					（1）弹出stackData的栈顶元素，记为value，与stackMin的栈顶元素比较、
 * 					（2）由于value只能大于或等于stackMin的栈顶元素，所以等于时，stackMin弹出栈顶元素；
 * 						大于时，stackMin不弹出，直接返回value
 * 
 * 			3、最小值：
 * 					stackMin的栈顶元素始终为最小值
 * 
 * 		方案二、
 * 			1、压入规则：
 * 					（1）假设数据为newData，现将其压入stackData中，然后判断stackMin中是否为空
 * 					（2）如果为空，则newData直接压入stackMin中
 * 					（3）如果不为空，比较newData和stackMin的栈顶值，
 * 						如果为不大于，则newData也压入stackMin中
 * 						如果小于，则将stackMin的栈顶元素再次入栈一次		
 * 			2、弹出规则：
 * 					（1）在stackData中弹出栈顶元素，记为value，
 * 					（2）弹出stackMin的栈顶元素，返回value
 * 			3、最小值：
 * 					stackMin的栈顶元素始终为stackData的最小值
 * 
 * 		注：时间复杂度都为O(1),空间复杂度都为O(n)
 * 
 */			

public class Test1 {
		
	
	public static void main(String[] args) {
		MyStack2 stack2 = new MyStack2();
		stack2.push(4);
		stack2.push(3);
		
		stack2.push(1);
		stack2.push(2);
		
		
		System.out.println(stack2.pop());
		System.out.println("此时最小值为："+stack2.getMin());
		System.out.println(stack2.pop());
		System.out.println("此时最小值为："+stack2.getMin());
		System.out.println(stack2.pop());
		System.out.println("此时最小值为："+stack2.getMin());
		System.out.println(stack2.pop());
	}
}

//方案一
class MyStack1{
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack1(){                                     
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
		
	}
	
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}
		else if(newNum <= this.getMin()){
			this.stackMin.push(newNum);
		}
			this.stackData.push(newNum);
	}
	
	public int pop(){
		if(this.stackData.isEmpty())
			throw new RuntimeException("stackData栈为空");
		int value = this.stackData.pop();
		if(value == this.getMin())
			this.stackMin.pop();
		return value;
	}
	
	public int getMin(){
		if(this.stackMin.isEmpty())
			throw new RuntimeException("stackMin栈为空！");
		return stackMin.peek();
	}
	
}

//方案二

class MyStack2{
	public Stack<Integer> stackData;
	public Stack<Integer> stackMin;
	
	public MyStack2(){
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}
	
	public void push(int newNum){
		if(this.stackMin.isEmpty())
			this.stackMin.push(newNum);
		else if(newNum <= this.getMin())
			this.stackMin.push(newNum);
		else {
			int top = this.stackMin.peek();
			this.stackMin.push(top);
		}
		this.stackData.push(newNum);
	}
	
	public int pop(){
		if(this.stackMin.isEmpty())
			throw new RuntimeException("stackMin栈为空！");
		int value = this.stackData.pop();
		this.stackMin.pop();
		return value;
	}
	
	public int getMin(){
		if(this.stackMin.isEmpty())
			throw new RuntimeException("stackMin栈为空！");
		return stackMin.peek();
	}
	
}