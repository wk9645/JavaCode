package com.example.deleteNode;

import java.util.Random;
import java.util.Scanner;


/*
 * 
 * 按照降序删除节点
 */

public class DeleteNode {
	
	
	//remove()方法，删除与给定值相同的节点
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
	
	
	//获取list中的最大值
	public static Node<Integer> getMaxNode(Node<Integer> front){
		Node<Integer> maxNode = front;
		Node<Integer> curr = front.next;
		Integer maxValue = front.nodeValue;
		//相当于两个指针，maxNode与curr的值比较取最大值，然后遍历整个list
		while(curr !=null){
			if(maxValue.compareTo(curr.nodeValue)<0){  
				maxValue = curr.nodeValue;
				maxNode = curr;
			}
			curr = curr.next;
		}
		return maxNode;
	}
	
	//遍历链表
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
		// TODO 自动生成的方法存根
		Node<Integer> front = null, newNode,p;
		
		Random rnd = new Random();
		Scanner keyIn = new Scanner(System.in);
		int listCount, i;
		System.out.print("Enter the size of the list:");
		System.out.println();
	    listCount = keyIn.nextInt();
		
	    for(i=0;i<listCount;i++){
	    	newNode = new Node<Integer>(rnd.nextInt(100));
	    	newNode.next=front;   //从右向左依次创建新的节点
	    	front = newNode;
	    
	    }
		
	    System.out.print("Original list:");
	    System.out.print(DeleteNode.check(front));
	    System.out.println();
	    System.out.print("Ordered list:");
	    
	    //找到链表中的最大值后输出，然后在链表中删除，直到将链表为空
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
		// TODO 自动生成的构造函数存根
		nodeValue=null;
		next=null;
	}
	
	public Node(T item){
		this.nodeValue = item;
		next = null;
	}
}