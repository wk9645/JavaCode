package com.wk.entity;


/*
 * 2、学生对象
 */

public class Student {

	private int id;		//学号
	private String name;	//学生姓名
	private String pwd;		//密码
	private int age;		//年龄
	private String gender;	//性别
	private String address;	//地址
	
	//无参构造函数
	public Student() {}
	
	//带参数构造函数
	public Student(int id, String name, String pwd, int age, String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", pwd=" + pwd + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + "]";
	}
	
}
