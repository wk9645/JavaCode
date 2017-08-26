package com.example.wk.cnode;

public class CNode<T> {
	T nodeValue;
	CNode<T> next;
	CNode<T> prev;
	public CNode() {
		// TODO �Զ����ɵĹ��캯�����
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
