package com.example.wk.cnode;

public class DbLinkedlist<T> {
	
	//�ڲ��࣬����һ���½ڵ�
	public static class CNode<T> {
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
	private CNode<T> header;
	private int size;
	//ѭ�������췽��
	public DbLinkedlist(){
		header=new CNode(null,null,null);
		header.prev=header.next=header;
		size=0;
	}
	
	//��ȡ������
	public int size(){
		return this.size;
	}
	
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty(){
		return this.size==0;
	}
	
	//���һ���ڵ�
	private boolean add(CNode<T> node, T value)  
	    {  
	        //�½�һ���ڵ㣬�½ڵ��nextָ��node���½ڵ��prevָ��node��pre  
	        //���ָ�����node.prev��newNode��node  
	        CNode<T> newNode = new CNode<T>(value, node, node.prev);  
	        //ά��˫�������ָ�򣬽�node��prev�ڵ��nextָ���½ڵ�,���ָ�����node.prev��newNode  
	        node.prev.next = newNode;  
	        //node�ڵ��ǰһ���ڵ�ָ���½ڵ㣬���ָ�����newNode��node  
	        node.prev = newNode;  
	        //�������д��벻�ܵߵ�������node��ǰһ���ڵ�ᱻ���ǳ��½ڵ㣬�ᶪʧnodeԭ����ǰһ���ڵ��nextָ��  
	        //���������������node�ڵ��nodeǰһ���ڵ�֮�����һ���½ڵ㣬��ά����˫���ϵ  
	        this.size++;  
	        return true;  
	    }  
	      
	//ָ��index������ڵ�  
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
	
	//ɾ������
	public T remove(CNode<T> node){
		node.prev.next=node.next;
		node.next.prev=node.prev;
		node.prev=node.next=null;
		T value=node.nodeValue;
		value=null;
		return value;
	
	}
	
	//ɾ��ĳ�������Ľڵ�
	public T remove(int index){
		return remove(entry(index));
	}
	
	
	//������ָ�������Ľڵ�
	private CNode<T> entry(int index){
		rangeIndex(index);  //�ж�index�Ƿ�Խ��
		
		CNode<T> node=this.header;
		//���indexС��size��һ�룬���header˳����������������
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
	
	//�ж��Ƿ�Խ��
	private void rangeIndex(int index){
		if(index<0||index>=this.size){
			throw new IndexOutOfBoundsException("index����");
		}
	}
}
