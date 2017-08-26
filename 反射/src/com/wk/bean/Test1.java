package com.wk.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/*
 * 内省：加强版反射，把对象的属性封装到对象中
 * 
 */

public class Test1 {

	public static void main(String[] args) throws IntrospectionException, Exception {
//		getProperty();
		getAllProperty();
	}
	
	
	
	//获取单个属性
	public static void getProperty() throws IntrospectionException,Exception{
		
		Person person = new Person();
		//创建属性描述器
		PropertyDescriptor descriptor = new PropertyDescriptor("name",Person.class);
		/*
			获取属性所对应的get或set方法来设置属性或者获取属性
			通过调用PropertyDescriptor的getWriteMethod方法或getReadMethod方法
			返回一个Method对象
		*/
		
		//设置属性
		Method set = descriptor.getWriteMethod();
	
		set.invoke(person, "lisi");
		//获取属性
		Method get = descriptor.getReadMethod();
		
		System.out.println(get.invoke(person, null));
//		System.out.println(person);
	}
	
	
	
	
	//获取所有属性
	public static void getAllProperty() throws IntrospectionException,Exception{
		
		
		//使用内省类Introspector获取Bean信息
		BeanInfo info = Introspector.getBeanInfo(Person.class);
		
		//通过BeanInfo获取所有getter方法
		PropertyDescriptor[] properties = info.getPropertyDescriptors();
		for(PropertyDescriptor property : properties){
			System.out.println(property.getReadMethod());
		}
		
		
		
	}
	
}
