package com.wk.stack;

import java.util.Stack;


/*
 * ������һ��ջʵ����һ��ջ�����򣨴�ջ����ջ���ɴ�С����
 * 
 * ˼·��1����������ջ��һ��Ϊ����ջstack��һ��Ϊ����ջhelp
 * 	    2������stack��ջ��Ԫ�ؼ�Ϊcurr�������helpջ��Ԫ��head�Ƚ�
 * 			��1�����currС�ڻ����head����currѹ��help��
 * 			��2�����curr����head����helpԪ������ѹ��stack�У�
 * 				ֱ��������һ������curr��Ԫ��λ��Ϊֹ,Ȼ��currѹ��help��
 * 		3����stack�е�Ԫ��Ϊ��ʱ����help�е�Ԫ������ѹ��stack�м���
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
