package com.niuke;

import java.util.ArrayList;
import java.util.Stack;


/*
 * ���⣺������ջ��ʵ��һ�����У���ɶ��е�push��pop�����������е�Ԫ��Ϊint���͡�
 * 
 * ˼·����������ջA,B��ջA��������ջ������Bջ��������ջ������
 * 	          ���A,B����ջ��Ϊ�գ����ܽ��г��Ӳ�����
 * 		���Ϊ��Ӳ�����B��Ϊ��ʱ����Ӧ�ý�B�е�Ԫ���˻�ջA��Ȼ��ջA����push
 * 		���Ϊ���Ӳ�����A��Ϊ��ʱ����Ӧ��A�е�Ԫ��push��ջB��Ȼ��ջB����pop
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
		System.out.println("ͨ��ջ1�����"+sQuene.stack1.pop());
		System.out.println("ͨ������ջ�����"+sQuene.pop());
	}
}
class StackQuene{
	
	ArrayList<Integer> list;
	//��������ջ
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	//ʵ��push����
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
	//ʵ��pop����
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
