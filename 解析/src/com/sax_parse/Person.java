package com.sax_parse;

public class Person {

	private String age;
	private String name;
	private String id;
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "[id="+id+",name="+name+",age="+age+"]";
	}
	
}
