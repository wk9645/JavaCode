package com.wk.bean;

public class Person {

	String name;
	int id;
	int salary;
	
	
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	*/
	@Override
	public String toString() {
		return "id:"+this.id+"\nname:"+this.name+"\nsalary:"+this.salary;
	}
	
	
	
}
