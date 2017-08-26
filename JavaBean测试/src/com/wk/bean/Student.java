package com.wk.bean;

import java.util.Date;

public class Student {

	private String name;
	private int age;
	private Date birth;
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}
	
}
