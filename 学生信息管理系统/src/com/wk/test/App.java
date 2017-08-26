package com.wk.test;

import java.util.Scanner;

import com.wk.entity.Student;
import com.wk.exception.FailedStudentException;
import com.wk.service.IAdminService;
import com.wk.service.impl.AdminService;


/**
 * 测试类
 * @author wk
 *
 */

public class App {
	
	private static Scanner input;
	private static IAdminService service = new AdminService();
	
	
	
	
	public static void main(String[] args) {

		input = new Scanner(System.in);
		
		System.out.println("请输入管理员账号：");
		String adminName = input.next();
		
		System.out.println("请输入管理员密码：");
		String pwd = input.next();
		
		boolean isAdmin = service.login(adminName, pwd);
		if(!isAdmin){
			System.out.println("用户名或密码错误，请重新登录！");
		}else{
			
			while(true){
				System.out.println("********欢迎进入学生管理系统*******");
				function();
				System.out.println("请输入要进行操作的序号：");
				int select = input.nextInt();
				switch (select) {
				case 1:
					//1、查看所有学生信息
					service.listAll();
					break;
				case 2:
					try {
						//2、查找学生
						System.out.println("请输入要查找的学生id:");
						int id = input.nextInt();
						service.findById(id);
					} catch (FailedStudentException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					//3、查找某年龄段学生个数
					System.out.println("请输入年龄最小和最大值(以逗号隔开)：");
					String ages = input.next();
					String[] age = ages.split(",");
					int maxAge = Integer.parseInt(age[1]);
					int minAge = Integer.parseInt(age[0]);
					int num = service.findByAge(minAge, maxAge);;
					System.out.println("年龄在" + minAge + "~" + maxAge + "岁的学生个数为：" + num + "人");
					break;
				case 4:
					//4、删除学生
					int count = 0;
					boolean delSucc = false;
					String stuName = null;
					System.out.println("请输入要删除学生的姓名：");
					while(count++ < 3){
						stuName = input.next();
						delSucc = service.delete(stuName);
						if(delSucc){
							service.listAll();
							break;
						}else{
							if(count < 3)
								System.out.println("输入错误，请重新输入！");
							else
								System.out.println("连续3次输入错误，系统自动退出！！！");
						}
					}
					if(count >= 3)
						System.exit(0);
					break;
				case 5:
					//5、不满18岁的女生年龄加一
					service.addAge4Femail();		
					break;
				case 6:
					//6、添加学生
					Student stu = new Student();
					System.out.println("请输入要添加的学生信息(输入格式：姓名-密码-年龄-性别-地址)");
					String newStu = input.next();
					//用"-"拆分字符串
					String[] newStuInfo = newStu.split("-");
					stu.setName(newStuInfo[0]);
					stu.setPwd(newStuInfo[1]);
					stu.setAge(Integer.parseInt(newStuInfo[2]));
					stu.setGender((newStuInfo[3]));
					stu.setAddress((newStuInfo[4]));
					service.addNewInLast(stu);
					break;
				case 0:
					//0、退出系统
					System.out.println("感谢您的使用！再见！");
					System.exit(0);
				default:
					break;
				}
			}
		}
	}
	
	public static void function(){
		System.out.println("********1、查看所有学生信息*******");
		System.out.println("********2、查找学生*************");
		System.out.println("********3、查找某年龄段学生个数****");
		System.out.println("********4、删除学生*************");
		System.out.println("********5、不满18岁的女生年龄加一**");
		System.out.println("********6、添加学生*************");
		System.out.println("********0、退出系统*************");
		System.out.println("******************************");
	}
	
}
