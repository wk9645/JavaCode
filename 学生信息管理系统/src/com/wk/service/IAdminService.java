package com.wk.service;

import com.wk.entity.Student;
import com.wk.exception.FailedStudentException;

public interface IAdminService {

	/*
	 * ����Աҵ�񷽷��ӿ�
	 */
	
	/**
	 * 1����¼
	 * @param adminName		��½���û���
	 * @param pwd			��½������
	 * @return				���ص�¼״̬
	 */
	
	boolean login(String adminName,String pwd);
	
	/**
	 * 2���г�����ѧ����Ϣ
	 */
	void listAll();
	
	/**
	 * 3������ѧ�Ų���ĳ��ѧ����Ϣ
	 * @param id	ѧ��ѧ��
	 */
	void findById(int id) throws FailedStudentException;
	
	
	/**
	 * 4������ָ������ε�ѧ������
	 * @param start	��ʼ����
	 * @param end	��ֹ����
	 * @return	����ѧ������
	 */
	int findByAge(int start, int end);
	
	
	/**
	 * 5��ɾ��ָ������ѧ��
	 * @param name
	 * @return ����trueΪɾ���ɹ�
	 */
	boolean delete(String name);
	
	/**
	 * 6������18�������Ů�������1
	 * @param stu	ѧ��
	 */
	void addAge4Femail();
	
	
	/**
	 * 7�����һ����ѧ������Ϊ���һ����Ϣ
	 * @param stu	�����ѧ��
	 */
	void addNewInLast(Student stu);
}
