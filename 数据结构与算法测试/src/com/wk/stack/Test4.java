package com.wk.stack;

import java.util.Stack;


/*
 * 需求：用一个栈实现另一个栈的排序（从栈顶到栈底由大到小排序）
 * 
 * 思路：1、创建两个栈，一个为排序栈stack，一个为辅助栈help
 * 	    2、弹出stack的栈顶元素记为curr，将其和help栈顶元素head比较
 * 			（1）如果curr小于或等于head，则将curr压入help中
 * 			（2）如果curr大于head，则将help元素依次压入stack中，
 * 				直到遇到第一个大于curr的元素位置为止,然后将curr压入help中
 * 		3、当stack中的元素为空时，将help中的元素依次压入stack中即可
 * 
 */
public class Test4 {
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(5);
		stack.add(1);
		stack.add(3);
		stack.add(9);
		stack.add(7);
		sortWithStack(stack);	
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
	
	public static void sortWithStack(Stack<Integer> stack){
		
		Stack<Integer> help = new Stack<Integer>();
		
		while(!stack.isEmpty()){
			int curr = stack.pop();
			while(!help.isEmpty() && curr > help.peek()){
				stack.push(help.pop());
			}
			help.push(curr);
		}
		
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	
 	} 
	
}
