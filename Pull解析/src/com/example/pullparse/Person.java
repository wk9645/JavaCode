package com.example.pullparse;

public class Person {
	
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		
	}
	
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return "person["+id+","+name+","+age+"]";
	}
	
	
}
