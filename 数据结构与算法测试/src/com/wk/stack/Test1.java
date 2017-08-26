package com.wk.stack;
import java.util.Stack;

/*
 * ���⣺ʵ��һ�������ջ����ʵ��ջ�Ļ��������ϣ���ʵ�ַ���ջ����СԪ�صĹ���
 * 
 * 
 * ˼·��ʹ������ջ��һ���������浱ǰջ��Ԫ�أ���ΪstackData��
 * 				��һ��ջ��������ÿһ������Сֵ����ΪstackMin
 * 		����һ��
 * 			1��ѹ�����
 * 					��1����������ΪnewData���ֽ���ѹ��stackData�У�Ȼ���ж�stackMin���Ƿ�Ϊ��
 * 					��2�����Ϊ�գ���newDataֱ��ѹ��stackMin��
 * 					��3�������Ϊ�գ��Ƚ�newData��stackMin��ջ��ֵ��
 * 						���Ϊ�����ڣ���newDataҲѹ��stackMin�У����򲻽���ѹ��
 * 
 * 			2����������
 * 					��1������stackData��ջ��Ԫ�أ���Ϊvalue����stackMin��ջ��Ԫ�رȽϡ�
 * 					��2������valueֻ�ܴ��ڻ����stackMin��ջ��Ԫ�أ����Ե���ʱ��stackMin����ջ��Ԫ�أ�
 * 						����ʱ��stackMin��������ֱ�ӷ���value
 * 
 * 			3����Сֵ��
 * 					stackMin��ջ��Ԫ��ʼ��Ϊ��Сֵ
 * 
 * 		��������
 * 			1��ѹ�����
 * 					��1����������ΪnewData���ֽ���ѹ��stackData�У�Ȼ���ж�stackMin���Ƿ�Ϊ��
 * 					��2�����Ϊ�գ���newDataֱ��ѹ��stackMin��
 * 					��3�������Ϊ�գ��Ƚ�newData��stackMin��ջ��ֵ��
 * 						���Ϊ�����ڣ���newDataҲѹ��stackMin��
 * 						���С�ڣ���stackMin��ջ��Ԫ���ٴ���ջһ��		
 * 			2����������
 * 					��1����stackData�е���ջ��Ԫ�أ���Ϊvalue��
 * 					��2������stackMin��ջ��Ԫ�أ�����value
 * 			3����Сֵ��
 * 					stackMin��ջ��Ԫ��ʼ��ΪstackData����Сֵ
 * 
 * 		ע��ʱ�临�Ӷȶ�ΪO(1),�ռ临�Ӷȶ�ΪO(n)
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
		System.out.println("��ʱ��СֵΪ��"+stack2.getMin());
		System.out.println(stack2.pop());
		System.out.println("��ʱ��СֵΪ��"+stack2.getMin());
		System.out.println(stack2.pop());
		System.out.println("��ʱ��СֵΪ��"+stack2.getMin());
		System.out.println(stack2.pop());
	}
}

//����һ
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
			throw new RuntimeException("stackDataջΪ��");
		int value = this.stackData.pop();
		if(value == this.getMin())
			this.stackMin.pop();
		return value;
	}
	
	public int getMin(){
		if(this.stackMin.isEmpty())
			throw new RuntimeException("stackMinջΪ�գ�");
		return stackMin.peek();
	}
	
}

//������

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
			throw new RuntimeException("stackMinջΪ�գ�");
		int value = this.stackData.pop();
		this.stackMin.pop();
		return value;
	}
	
	public int getMin(){
		if(this.stackMin.isEmpty())
			throw new RuntimeException("stackMinջΪ�գ�");
		return stackMin.peek();
	}
	
}