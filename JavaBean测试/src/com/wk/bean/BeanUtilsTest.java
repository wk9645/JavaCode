package com.wk.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class BeanUtilsTest {

	
	
	//使用BeanUtils加载类
	@Test
	public void test1(){
		
		Student stu = new Student();
		try {
			//设置属性
			BeanUtils.setProperty(stu, "name", "张三");
			BeanUtils.copyProperty(stu, "age", 18);
			
			System.out.println(stu.getName()+"-"+stu.getAge());
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	//封装表单提交数据
	@Test
	public void test2(){
		
		String name = "李四";
		int age = 45;
		String birth = "1996-4-5";
		
		Student student = new Student();
		Map<String, Object> stu = new HashMap<>();
		stu.put("name", name);
		stu.put("age", age);
		
		try {
			BeanUtils.populate(student,stu);
			System.out.println(student.getName()+"-"+student.getAge());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	//对时间类型的转换
	@Test
	public void test3(){
		
		String name = "王五";
		int age = 4;
		String birth = "1996-4-5";
		
		Student stu = new Student();
		
	/*	//注册类型转换器,自定义转化器
		ConvertUtils.register(new Converter() {
			
			@Override
			public Object convert(Class type, Object value) {
				
				if(type != Date.class || type == null || "".equals(value.toString().trim()))
					return null;
				
				//如果为Date类型
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					return format.parse(value.toString());
				} catch (ParseException e) {
					throw new RuntimeException();
				}
				
			}
		}, Date.class);
		*/
		
		//Java中自带日期转换器
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		try {
			BeanUtils.copyProperty(stu, "name", name);
			BeanUtils.copyProperty(stu, "age", age);
			BeanUtils.copyProperty(stu, "birth", birth);
			
			System.out.println(stu);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}
	
}