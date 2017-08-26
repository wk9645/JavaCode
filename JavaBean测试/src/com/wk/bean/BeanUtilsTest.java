package com.wk.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class BeanUtilsTest {

	
	
	//ʹ��BeanUtils������
	@Test
	public void test1(){
		
		Student stu = new Student();
		try {
			//��������
			BeanUtils.setProperty(stu, "name", "����");
			BeanUtils.copyProperty(stu, "age", 18);
			
			System.out.println(stu.getName()+"-"+stu.getAge());
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	
	//��װ���ύ����
	@Test
	public void test2(){
		
		String name = "����";
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	
	//��ʱ�����͵�ת��
	@Test
	public void test3(){
		
		String name = "����";
		int age = 4;
		String birth = "1996-4-5";
		
		Student stu = new Student();
		
	/*	//ע������ת����,�Զ���ת����
		ConvertUtils.register(new Converter() {
			
			@Override
			public Object convert(Class type, Object value) {
				
				if(type != Date.class || type == null || "".equals(value.toString().trim()))
					return null;
				
				//���ΪDate����
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					return format.parse(value.toString());
				} catch (ParseException e) {
					throw new RuntimeException();
				}
				
			}
		}, Date.class);
		*/
		
		//Java���Դ�����ת����
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		try {
			BeanUtils.copyProperty(stu, "name", name);
			BeanUtils.copyProperty(stu, "age", age);
			BeanUtils.copyProperty(stu, "birth", birth);
			
			System.out.println(stu);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
	}
	
}