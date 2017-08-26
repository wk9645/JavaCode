package com.wk.collection;


import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * 泛型限定测试
 */


 public class FTest {

	public static void main(String[] args) {
		TreeSet<Student> tSet= new TreeSet<Student>(new Compar());
		tSet.add(new Student("abc"));
		tSet.add(new Student("bca"));
		tSet.add(new Student("cba"));
		
		Iterator<Student> it = tSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		TreeSet<Worker> tSet2= new TreeSet<Worker>(new Compar());
		tSet2.add(new Worker("abcw"));
		tSet2.add(new Worker("bcaw"));
		tSet2.add(new Worker("cbaw"));
		
		Iterator<Worker> it2 = tSet2.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
}

class Compar implements Comparator<People>{

	@Override
	public int compare(People p1,People p2) {
		// TODO 自动生成的方法存根
		return p1.getName().compareTo(p2.getName());
	}
	
}


class People{
	private String name;
	public People(String name) {
		// TODO 自动生成的构造函数存根
		this.name = name;
	}
	public String getName(){
		return name;
	}
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return "person--"+name;
	}
	
}

class Student extends People{
	public Student(String name) {
		// TODO 自动生成的构造函数存根
		super(name);
	}
}

class Worker extends People{
	public Worker(String name) {
		// TODO 自动生成的构造函数存根
		super(name);
	}
}
