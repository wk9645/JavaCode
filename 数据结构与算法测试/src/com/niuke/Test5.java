package com.niuke;

import java.util.ArrayList;
import java.util.Stack;


/*
 * 问题：用两个栈来实现一个队列，完成队列的push和pop操作。队列中的元素为int类型。
 * 
 * 思路：构建两个栈A,B，栈A用来做入栈操作，B栈用来做出栈操作，
 * 	          如果A,B两个栈都为空，则不能进行出队操作；
 * 		如果为入队操作，B不为空时，则应该将B中的元素退回栈A，然后栈A进行push
 * 		如果为出队操作，A不为空时，则应将A中的元素push进栈B，然后栈B进行pop
 * 
 * 
 */
public class Test5 {

	public static void main(String[] args) {
		Test5 t = new Test5();
		int a=5;
		int b=6;
		StackQuene sQuene = new StackQuene();
		sQuene.push(a);
		sQuene.push(b);
		System.out.println("通过栈1输出："+sQuene.stack1.pop());
		System.out.println("通过两个栈输出："+sQuene.pop());
	}
}
class StackQuene{
	
	ArrayList<Integer> list;
	//创建两个栈
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	//实现push功能
	public void push(int node){
		if(stack2.empty()){
			stack1.push(node);
		}else{
			while(stack2.peek()!= null){
				stack1.push(stack2.pop());
			}
			stack1.push(node);
		}
	}
	//实现pop功能
	public int pop(){
		int a=-1;
		
			if(stack1.empty()){
				if(!stack2.empty())
				a=stack2.pop();
			}
			else{
				while(!stack1.empty()){
					stack2.push(stack1.pop());
				}
				if(!stack2.empty())
				a=stack2.pop();
			}
		
		return a;
	}		
}
