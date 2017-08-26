package com.wk.service;

import com.wk.entity.Student;
import com.wk.exception.FailedStudentException;

public interface IAdminService {

	/*
	 * 管理员业务方法接口
	 */
	
	/**
	 * 1、登录
	 * @param adminName		登陆的用户名
	 * @param pwd			登陆的密码
	 * @return				返回登录状态
	 */
	
	boolean login(String adminName,String pwd);
	
	/**
	 * 2、列出所有学生信息
	 */
	void listAll();
	
	/**
	 * 3、根据学号查找某个学生信息
	 * @param id	学生学号
	 */
	void findById(int id) throws FailedStudentException;
	
	
	/**
	 * 4、查找指定年龄段的学生个数
	 * @param start	起始年龄
	 * @param end	终止年龄
	 * @return	返回学生个数
	 */
	int findByAge(int start, int end);
	
	
	/**
	 * 5、删除指定姓名学生
	 * @param name
	 * @return 返回true为删除成功
	 */
	boolean delete(String name);
	
	/**
	 * 6、不满18岁的所有女生年龄加1
	 * @param stu	学生
	 */
	void addAge4Femail();
	
	
	/**
	 * 7、添加一个新学生并作为最后一条信息
	 * @param stu	新添加学生
	 */
	void addNewInLast(Student stu);
}
