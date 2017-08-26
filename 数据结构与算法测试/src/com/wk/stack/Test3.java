package com.wk.stack;

import java.util.Stack;


/*
 * ����ʹ�õݹ�ʵ��һ��ջ������
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
	
	//��ջ��ջ��Ԫ�ط��ز��Ƴ�
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
	
	//��ջ��Ԫ����ת
	
	public static void reverse(Stack<Integer> num){
		if(num.isEmpty()){
			return;
		}
		int result = getAndRemoveLast(num);
		reverse(num);
		num.push(result);
	}
}
