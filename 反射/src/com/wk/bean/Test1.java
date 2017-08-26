package com.wk.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/*
 * ��ʡ����ǿ�淴�䣬�Ѷ�������Է�װ��������
 * 
 */

public class Test1 {

	public static void main(String[] args) throws IntrospectionException, Exception {
//		getProperty();
		getAllProperty();
	}
	
	
	
	//��ȡ��������
	public static void getProperty() throws IntrospectionException,Exception{
		
		Person person = new Person();
		//��������������
		PropertyDescriptor descriptor = new PropertyDescriptor("name",Person.class);
		/*
			��ȡ��������Ӧ��get��set�������������Ի��߻�ȡ����
			ͨ������PropertyDescriptor��getWriteMethod������getReadMethod����
			����һ��Method����
		*/
		
		//��������
		Method set = descriptor.getWriteMethod();
	
		set.invoke(person, "lisi");
		//��ȡ����
		Method get = descriptor.getReadMethod();
		
		System.out.println(get.invoke(person, null));
//		System.out.println(person);
	}
	
	
	
	
	//��ȡ��������
	public static void getAllProperty() throws IntrospectionException,Exception{
		
		
		//ʹ����ʡ��Introspector��ȡBean��Ϣ
		BeanInfo info = Introspector.getBeanInfo(Person.class);
		
		//ͨ��BeanInfo��ȡ����getter����
		PropertyDescriptor[] properties = info.getPropertyDescriptors();
		for(PropertyDescriptor property : properties){
			System.out.println(property.getReadMethod());
		}
		
		
		
	}
	
}
