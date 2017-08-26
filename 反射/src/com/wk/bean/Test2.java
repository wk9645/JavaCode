package com.wk.bean;

import org.apache.commons.beanutils.BeanUtils;

/*
 * BeanUtils 把对象属性封装到对象中
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
		//使用BeanUtils得setProperty方法设置属性
		BeanUtils.setProperty(p, "id", id);
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "salary", salary);
		System.out.println(p);
	}
	
	
}
