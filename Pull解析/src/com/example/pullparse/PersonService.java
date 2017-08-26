package com.example.pullparse;

import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class PersonService {
	
	public static ArrayList<Person> getPersons(InputStream xml) throws Exception{
		
		ArrayList<Person> persons = null;
		Person person = null;
		
		//�õ�һ��Pull������
		XmlPullParser pullParser = Xml.newPullParser();
		//����Ҫ�������ļ��ͱ��뷽ʽ
		pullParser.setInput(xml, "UTF-8");
		//�õ��¼�����
		int event = pullParser.getEventType();
		while(event != XmlPullParser.END_DOCUMENT){
			switch(event){
			
				//������ĵ���ʼ
				case XmlPullParser.START_DOCUMENT:
					persons = new ArrayList<Person>();
					
					break;
				//����Ǳ�ǩ��ʼ
				case XmlPullParser.START_TAG:
					if("person".equals(pullParser.getName())){
						int id = Integer.valueOf(pullParser.getAttributeValue(0));
						person = new Person();
						person.setId(id);
						
					}
					
					if("name".equals(pullParser.getName())){
						String name = pullParser.nextText();
						person.setName(name);
					}
					
					if("age".equals(pullParser.getName())){
						int age = Integer.valueOf(pullParser.nextText());
						person.setAge(age);
					}
					
					break;
				case XmlPullParser.END_TAG:
					if("person".equals(pullParser.getName())){
						persons.add(person);
						person = null;
					}
					break;
			}
			pullParser.next();
			
		}
		return persons;
	}
	
}
