package com.wk.entity;


/*
 * 2��ѧ������
 */

public class Student {

	private int id;		//ѧ��
	private String name;	//ѧ������
	private String pwd;		//����
	private int age;		//����
	private String gender;	//�Ա�
	private String address;	//��ַ
	
	//�޲ι��캯��
	public Student() {}
	
	//���������캯��
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
