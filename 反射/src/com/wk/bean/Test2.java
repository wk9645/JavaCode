package com.wk.bean;

import org.apache.commons.beanutils.BeanUtils;

/*
 * BeanUtils �Ѷ������Է�װ��������
 * 
 * 
 */
public class Test2 {

	public static void main(String[] args) throws Exception {
		testBeanUtils();
	}
	
	
	public static void testBeanUtils() throws Exception{
		String id = "110";
		String name = "zhangsan";
		String salary = "1000";
		Person p = new Person();
		//ʹ��BeanUtils��setProperty������������
		BeanUtils.setProperty(p, "id", id);
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "salary", salary);
		System.out.println(p);
	}
	
	
}
