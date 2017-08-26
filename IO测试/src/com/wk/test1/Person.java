package com.wk.test1;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 8007907607734036253L;
	
	private String name;
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
