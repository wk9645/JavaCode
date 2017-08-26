package com.wk.test;

public class CirList {
	
	public static void main(String[] args) {
	
	}
}

class List<T>{
	
	Node<T> first;
	Node<T> last;
	
	int length;
	int index;
	
	//添加头结点
	public void addFirst(T value){
		
		if(first == null){
			Node<T> node = new Node<T>(null, null, value);
			this.first = node;
			this.last = node;
			length++;
		}else{
			Node<T> node = new Node<T>(null, first, value);
			this.first.prev = node;   //000
			this.first = node;
			
		}
		
	}
	
	//添加尾结点
	public void addLast(T value){
		
		if(last == null){
			Node<T> node = new Node<T>(null, null, value);
			this.first = node;
		}else{
			Node<T> node = new Node<T>(first, null, value);
			first.next = node;
		}
	}
	
	
	//获取当前节点索引
	public int getIndex() {
		return index;
	}
	
	
	//设置当前节点索引
	public void setIndex(int index) {
		this.index = index;
	}
}
	
//节点类
class Node<T>{

	Node<T> next;
	Node<T> prev;
	T value = null;
	
	public Node(Node<T> prev, Node<T> next, T value){
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
}
	
	



