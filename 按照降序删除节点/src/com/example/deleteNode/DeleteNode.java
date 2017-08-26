package com.example.deleteNode;

import java.util.Random;
import java.util.Scanner;


/*
 * 
 * ���ս���ɾ���ڵ�
 */

public class DeleteNode {
	
	
	//remove()������ɾ�������ֵ��ͬ�Ľڵ�
	private static Node<Integer> remove(Node<Integer> front,Integer target){
		
		Node<Integer> curr =front, prev=null;
		boolean foundItem = false;
		
		while(curr !=null&& !foundItem){
			if(target.equals(curr.nodeValue)){
				if(prev ==null)
					front=front.next;
				else
					prev.next=curr.next;
					foundItem=true;
			}
			else{
				prev=curr;
				curr=curr.next;
			}
		}
		return front;
	}
	
	
	//��ȡlist�е����ֵ
	public static Node<Integer> getMaxNode(Node<Integer> front){
		Node<Integer> maxNode = front;
		Node<Integer> curr = front.next;
		Integer maxValue = front.nodeValue;
		//�൱������ָ�룬maxNode��curr��ֵ�Ƚ�ȡ���ֵ��Ȼ���������list
		while(curr !=null){
			if(maxValue.compareTo(curr.nodeValue)<0){  
				maxValue = curr.nodeValue;
				maxNode = curr;
			}
			curr = curr.next;
		}
		return maxNode;
	}
	
	//��������
	public static String check(Node<Integer> front){
		if(front == null)
			return null;
		Node<Integer> curr = front;
		String str = "["+curr.nodeValue;
		while(curr.next != null){
			curr = curr.next;
			str+=","+curr.nodeValue;
		}
		str+="]";
		return str;
	}
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Node<Integer> front = null, newNode,p;
		
		Random rnd = new Random();
		Scanner keyIn = new Scanner(System.in);
		int listCount, i;
		System.out.print("Enter the size of the list:");
		System.out.println();
	    listCount = keyIn.nextInt();
		
	    for(i=0;i<listCount;i++){
	    	newNode = new Node<Integer>(rnd.nextInt(100));
	    	newNode.next=front;   //�����������δ����µĽڵ�
	    	front = newNode;
	    
	    }
		
	    System.out.print("Original list:");
	    System.out.print(DeleteNode.check(front));
	    System.out.println();
	    System.out.print("Ordered list:");
	    
	    //�ҵ������е����ֵ�������Ȼ����������ɾ����ֱ��������Ϊ��
	    while(front !=null){
	    	p=getMaxNode(front);
	    	System.out.print(p.nodeValue + " ");
	        front =DeleteNode.remove(front,p.nodeValue);
	    }
	    System.out.println();
	}

}

class Node<T>{
	public T nodeValue;
	public Node<T> next;
	
	public Node() {
		// TODO �Զ����ɵĹ��캯�����
		nodeValue=null;
		next=null;
	}
	
	public Node(T item){
		this.nodeValue = item;
		next = null;
	}
}