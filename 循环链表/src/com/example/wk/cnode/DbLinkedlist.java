package com.example.wk.cnode;

public class DbLinkedlist<T> {
	
	//内部类，创建一个新节点
	public static class CNode<T> {
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
	private CNode<T> header;
	private int size;
	//循环链表构造方法
	public DbLinkedlist(){
		header=new CNode(null,null,null);
		header.prev=header.next=header;
		size=0;
	}
	
	//获取链表长度
	public int size(){
		return this.size;
	}
	
	//判断链表是否为空
	public boolean isEmpty(){
		return this.size==0;
	}
	
	//添加一个节点
	private boolean add(CNode<T> node, T value)  
	    {  
	        //新建一个节点，新节点的next指向node，新节点的prev指向node的pre  
	        //完成指向过程node.prev←newNode→node  
	        CNode<T> newNode = new CNode<T>(value, node, node.prev);  
	        //维持双向链表的指向，将node的prev节点的next指向新节点,完成指向过程node.prev→newNode  
	        node.prev.next = newNode;  
	        //node节点的前一个节点指向新节点，完成指向过程newNode←node  
	        node.prev = newNode;  
	        //上面两行代码不能颠倒，否则node的前一个节点会被覆盖成新节点，会丢失node原来的前一个节点的next指向  
	        //上述代码完成了在node节点和node前一个节点之间加入一个新节点，并维护了双向关系  
	        this.size++;  
	        return true;  
	    }  
	      
	//指定index处加入节点  
	public boolean add(int index, T value)
	    {  
	        return add(entry(index), value);  
	    }  
	  
	      
	/*public static String toString(DbLinkedlist.CNode<String> header){
		if(header ==null){
			return null;
		}
		header=new DbLinkedlist.CNode<String>();
		CNode<String> curr=header;
		String str = "["+curr.nodeValue;
		while(curr.next !=header){
			curr=curr.next;
			str+=","+curr.nodeValue;
		}
		str+="]";
		return str;	
	}*/
	
	/*public static <T>boolean isEmpty(CNode<T> header){
		
		if(header==null){
			return true;
		}
		return false;	
	}*/
	
	//删除操作
	public T remove(CNode<T> node){
		node.prev.next=node.next;
		node.next.prev=node.prev;
		node.prev=node.next=null;
		T value=node.nodeValue;
		value=null;
		return value;
	
	}
	
	//删除某个索引的节点
	public T remove(int index){
		return remove(entry(index));
	}
	
	
	//迭代到指定索引的节点
	private CNode<T> entry(int index){
		rangeIndex(index);  //判断index是否越界
		
		CNode<T> node=this.header;
		//如果index小于size的一半，则从header顺序遍历，否则反向遍历
		if(index<(this.size>>1)){
			for(int i=0;i<=index;i++){
				node=node.next;
			}
		}
		else{
			for(int i=this.size-1;i>=index;i--){
				node=node.prev;
			}
		}
		return node;
	}
	
	//判断是否越界
	private void rangeIndex(int index){
		if(index<0||index>=this.size){
			throw new IndexOutOfBoundsException("index错误");
		}
	}
}
