package com.wk.service.impl;

import java.util.Arrays;

import com.wk.entity.Admin;
import com.wk.entity.Student;
import com.wk.exception.FailedStudentException;
import com.wk.service.IAdminService;

public class AdminService implements IAdminService {

	private static Student[] students;		//��ʼѧ������
	private Student[] stus = students;		//���ĺ�ѧ������
	private static Admin[] admins;
	
	static{
			
		//����ѧ����Ϣ
		  students = new Student[]{ 
				
				new Student(1,"����","pwd1",17,"Ů","�ɶ�"),
				new Student(2,"����","pwd1",18,"Ů","����"),
				new Student(3,"����","pwd1",26,"��","����"),
				new Student(4,"����","pwd1",16,"Ů","ʯ��ׯ"),
				new Student(5,"����","pwd1",19,"��","�ຣ"),
				new Student(6,"����","pwd1",16,"��","�Ϻ�"),
				new Student(7,"����","pwd1",20,"Ů","����"),
				new Student(8,"����","pwd1",17,"Ů","����")
		};
		
		//����Ա
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
		System.out.println("\t\tѧ����Ϣ");
		System.out.println("ѧ��" + "\t����" + "\t����" + "\t�Ա�" + "\t��ַ");
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
			System.out.println("��Ҫ�ҵ�ѧ����Ϣ���£�");
			System.out.println("ѧ�ţ�" + stu.getId());
			System.out.println("������" + stu.getName());
			System.out.println("���룺" + stu.getPwd());
			System.out.println("���䣺" + stu.getAge());
			System.out.println("�Ա�" + stu.getGender());
			System.out.println("��ַ��" + stu.getAddress());
		}else{
			throw new FailedStudentException("�����ҵ�ѧ�������ڣ�");
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
				
				//��ǰ����
				int currAge = stus[i].getAge();
				//add�������
				int ageAfterAdd = "Ů".equals(stus[i].getGender()) && currAge < 18 ? currAge +1 : currAge;
				stus[i].setAge(ageAfterAdd);
			}
		}
	}

	@Override
	public void addNewInLast(Student stu) {
		if(stu != null){
			//����һ����ǰѧ������ĸ��������ȼ�һ
			stus = Arrays.copyOf(stus, stus.length + 1);
			//����ѧ��
			stu.setId(stus.length);
			//��ѧ���������һλ
			stus[stus.length - 1] = stu;
		}
	}
}
