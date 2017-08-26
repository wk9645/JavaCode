package com.wk.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*
 * ��дһ�����߷��������������ļ������ݣ���ȡ
 * ���󲢽���ȡ�������ݷ�װ��������
 * 
 * 
 */

public class Text3 {
	public static void main(String[] args) throws Exception {
		Person person =(Person)getInstance();
		System.out.println(person);
	}
	
	public static Object getInstance() throws IOException, Exception{
		
		//��ȡ�ļ�
		BufferedReader reader = new BufferedReader(new FileReader("obj.txt"));
		
		String className = reader.readLine();
		//�Ի�ȡ�����ִ���һ����
		Class<?> objClass = Class.forName(className);
		//ͨ��class�����ȡ�޲ι��췽��
		Constructor<?> constructor = objClass.getConstructor(null);
		//��������
		Object object = constructor.newInstance(null);
		//��ȡ����ֵ
		String line = null;
		while((line = reader.readLine())!=null){
			String[] datas = line.split("=");
			//ͨ����������ȡ����Ӧ��Field����
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
