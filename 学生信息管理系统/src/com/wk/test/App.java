package com.wk.test;

import java.util.Scanner;

import com.wk.entity.Student;
import com.wk.exception.FailedStudentException;
import com.wk.service.IAdminService;
import com.wk.service.impl.AdminService;


/**
 * ������
 * @author wk
 *
 */

public class App {
	
	private static Scanner input;
	private static IAdminService service = new AdminService();
	
	
	
	
	public static void main(String[] args) {

		input = new Scanner(System.in);
		
		System.out.println("���������Ա�˺ţ�");
		String adminName = input.next();
		
		System.out.println("���������Ա���룺");
		String pwd = input.next();
		
		boolean isAdmin = service.login(adminName, pwd);
		if(!isAdmin){
			System.out.println("�û�����������������µ�¼��");
		}else{
			
			while(true){
				System.out.println("********��ӭ����ѧ������ϵͳ*******");
				function();
				System.out.println("������Ҫ���в�������ţ�");
				int select = input.nextInt();
				switch (select) {
				case 1:
					//1���鿴����ѧ����Ϣ
					service.listAll();
					break;
				case 2:
					try {
						//2������ѧ��
						System.out.println("������Ҫ���ҵ�ѧ��id:");
						int id = input.nextInt();
						service.findById(id);
					} catch (FailedStudentException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					//3������ĳ�����ѧ������
					System.out.println("������������С�����ֵ(�Զ��Ÿ���)��");
					String ages = input.next();
					String[] age = ages.split(",");
					int maxAge = Integer.parseInt(age[1]);
					int minAge = Integer.parseInt(age[0]);
					int num = service.findByAge(minAge, maxAge);;
					System.out.println("������" + minAge + "~" + maxAge + "���ѧ������Ϊ��" + num + "��");
					break;
				case 4:
					//4��ɾ��ѧ��
					int count = 0;
					boolean delSucc = false;
					String stuName = null;
					System.out.println("������Ҫɾ��ѧ����������");
					while(count++ < 3){
						stuName = input.next();
						delSucc = service.delete(stuName);
						if(delSucc){
							service.listAll();
							break;
						}else{
							if(count < 3)
								System.out.println("����������������룡");
							else
								System.out.println("����3���������ϵͳ�Զ��˳�������");
						}
					}
					if(count >= 3)
						System.exit(0);
					break;
				case 5:
					//5������18���Ů�������һ
					service.addAge4Femail();		
					break;
				case 6:
					//6�����ѧ��
					Student stu = new Student();
					System.out.println("������Ҫ��ӵ�ѧ����Ϣ(�����ʽ������-����-����-�Ա�-��ַ)");
					String newStu = input.next();
					//��"-"����ַ���
					String[] newStuInfo = newStu.split("-");
					stu.setName(newStuInfo[0]);
					stu.setPwd(newStuInfo[1]);
					stu.setAge(Integer.parseInt(newStuInfo[2]));
					stu.setGender((newStuInfo[3]));
					stu.setAddress((newStuInfo[4]));
					service.addNewInLast(stu);
					break;
				case 0:
					//0���˳�ϵͳ
					System.out.println("��л����ʹ�ã��ټ���");
					System.exit(0);
				default:
					break;
				}
			}
		}
	}
	
	public static void function(){
		System.out.println("********1���鿴����ѧ����Ϣ*******");
		System.out.println("********2������ѧ��*************");
		System.out.println("********3������ĳ�����ѧ������****");
		System.out.println("********4��ɾ��ѧ��*************");
		System.out.println("********5������18���Ů�������һ**");
		System.out.println("********6�����ѧ��*************");
		System.out.println("********0���˳�ϵͳ*************");
		System.out.println("******************************");
	}
	
}
