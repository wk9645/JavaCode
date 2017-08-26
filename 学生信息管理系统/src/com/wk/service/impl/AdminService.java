package com.wk.service.impl;

import java.util.Arrays;

import com.wk.entity.Admin;
import com.wk.entity.Student;
import com.wk.exception.FailedStudentException;
import com.wk.service.IAdminService;

public class AdminService implements IAdminService {

	private static Student[] students;		//初始学生数组
	private Student[] stus = students;		//更改后学生数组
	private static Admin[] admins;
	
	static{
			
		//基本学生信息
		  students = new Student[]{ 
				
				new Student(1,"大娃","pwd1",17,"女","成都"),
				new Student(2,"二娃","pwd1",18,"女","西安"),
				new Student(3,"三娃","pwd1",26,"男","北京"),
				new Student(4,"四娃","pwd1",16,"女","石家庄"),
				new Student(5,"五娃","pwd1",19,"男","青海"),
				new Student(6,"六娃","pwd1",16,"男","上海"),
				new Student(7,"七娃","pwd1",20,"女","重庆"),
				new Student(8,"八娃","pwd1",17,"女","海南")
		};
		
		//管理员
		admins = new Admin[]{
		
				new Admin("admin1","root"),
				new Admin("admin2","root"),
				new Admin("admin3","root")
		};
	}
	
	@Override
	public boolean login(String adminName, String pwd) {
		
		for(int i=0; i < admins.length; i++){
			if(admins[i].getAdminName().equals(adminName) && admins[i].getPwd().equals(pwd)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void listAll() {
		System.out.println("\t\t学生信息");
		System.out.println("学号" + "\t姓名" + "\t年龄" + "\t性别" + "\t地址");
		for(int i=0; i < stus.length; i++){
			if(stus[i] != null)
				System.out.println(stus[i].getId() + "\t" +
						stus[i].getName() + "\t" + 
						stus[i].getAge() + "\t" + 
						stus[i].getGender() + "\t" + 
						stus[i].getAddress());
		}
			
	}

	@Override
	public void findById(int id) throws FailedStudentException {
		Student stu = null;
		boolean find = false;
		for(int i=0; i < students.length; i++){
			if(students[i].getId() == id){
				stu = students[i];
				find = true;
			}			
		}
		if(find){
			System.out.println("您要找的学生信息如下：");
			System.out.println("学号：" + stu.getId());
			System.out.println("姓名：" + stu.getName());
			System.out.println("密码：" + stu.getPwd());
			System.out.println("年龄：" + stu.getAge());
			System.out.println("性别：" + stu.getGender());
			System.out.println("地址：" + stu.getAddress());
		}else{
			throw new FailedStudentException("您查找的学生不存在！");
		}
		
	}

	@Override
	public int findByAge(int start, int end) {
		int count = 0;
		for(int i=0; i < stus.length; i++){
			if(stus[i].getAge() >= start && stus[i].getAge() <= end)
				count++;
		}
		return count;
	}

	@Override
	public boolean delete(String name) {
		
		for(int i=0; i < stus.length; i++){
			
			if(stus[i].getName().equals(name)){
				stus[i] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public void addAge4Femail() {
		
		for(int i=0; i<stus.length; ++i){
			if(stus[i] != null){
				
				//当前年龄
				int currAge = stus[i].getAge();
				//add后的年龄
				int ageAfterAdd = "女".equals(stus[i].getGender()) && currAge < 18 ? currAge +1 : currAge;
				stus[i].setAge(ageAfterAdd);
			}
		}
	}

	@Override
	public void addNewInLast(Student stu) {
		if(stu != null){
			//复制一个当前学生数组的副本，长度加一
			stus = Arrays.copyOf(stus, stus.length + 1);
			//设置学号
			stu.setId(stus.length);
			//新学生放在最后一位
			stus[stus.length - 1] = stu;
		}
	}
}
