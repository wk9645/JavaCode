package com.wk.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*
 * 编写一个工具方法，根据配置文件的内容，获取
 * 对象并将获取到的内容封装到对象中
 * 
 * 
 */

public class Text3 {
	public static void main(String[] args) throws Exception {
		Person person =(Person)getInstance();
		System.out.println(person);
	}
	
	public static Object getInstance() throws IOException, Exception{
		
		//获取文件
		BufferedReader reader = new BufferedReader(new FileReader("obj.txt"));
		
		String className = reader.readLine();
		//以获取的名字创建一个类
		Class<?> objClass = Class.forName(className);
		//通过class对象获取无参构造方法
		Constructor<?> constructor = objClass.getConstructor(null);
		//创建对象
		Object object = constructor.newInstance(null);
		//读取属性值
		String line = null;
		while((line = reader.readLine())!=null){
			String[] datas = line.split("=");
			//通过属性名获取到对应的Field对象
			Field field = objClass.getDeclaredField(datas[0]);			
			if(field.getType() == int.class){
				field.set(object, Integer.parseInt(datas[1]));
			}else{
				field.set(object, datas[1]);
			}
		}
		reader.close();
		return object;
	}
	
}
