package com.wk.test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MySerializable {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		seralizable();
		deSerializable();
	}
	
	public static void seralizable() throws IOException{

		//����������������󱣴����ļ���
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src//person.txt"));
		
		Person p = new Person();
		p.setAge(18);
		p.setName("zhangsan");
		
		oos.writeObject(p.toString());
		
		oos.close();
		
	}
	
	//�����л�
	public static void deSerializable() throws IOException, ClassNotFoundException{
		
		//��ȡ�����ļ�������
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/person.txt"));
		
		Object obj = ois.readObject();
		String str = (String) obj;
		System.out.println(str);
		ois.close();
		
	}
	
}
