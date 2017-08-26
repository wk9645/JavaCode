package com.example.wk.cnode;

public class CNode<T> {
	T nodeValue;
	CNode<T> next;
	CNode<T> prev;
	public CNode() {
		// TODO 自动生成的构造函数存根
		nodeValue=null;
		next=null;
		prev=null;
	}
	
	public CNode(T item,CNode<T> next,CNode<T> prev){
		nodeValue=item;
		this.next=next;
		this.prev=prev;
	}
	
}
