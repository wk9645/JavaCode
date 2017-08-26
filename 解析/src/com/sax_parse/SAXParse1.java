package com.sax_parse;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* 
 * ʹ��SAX����,��xml�ļ���ӡ����
 *
 */


public class SAXParse1 {
	public static void main(String[] args) throws Exception {
		parsewithSAX();
	}
	
	public static void parsewithSAX() throws Exception, SAXException{
		
		//����SAXParser����
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		MyDefaultHandler handler = new MyDefaultHandler();
		parser.parse(new File("./src/person.xml"), handler);
		
		String content = handler.getContent();
		System.out.println(content);
		
	}
}



/*
 * 
 * �Զ���SAX�¼���������ʵ�������������
 * 
 */
class MyDefaultHandler extends DefaultHandler{

	private StringBuffer sb = new StringBuffer();
	
	public String getContent(){
		return sb.toString();
	}
	
	/**
	 * @param qName:��ʼ��ǩ�ı�ǩ��
	 * @param attributes:�����б�
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		sb.append("<"+qName);
		//�ж��Ƿ�������
		if(attributes != null){
			for(int i=0;i<attributes.getLength();i++){
				//�õ�������
				String attrName = attributes.getQName(i);
				String attrValue = attributes.getValue(i);
				sb.append(" "+attrName+"=\""+attrValue+"\"");
			}
		}
		
		sb.append(">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//������ǩ
		sb.append("</"+qName+">");
		
	}

	
	/**
	 * @param ch:��ʾ����֮ǰ�������ı�����
	 * @param start:��ʾ��ǰ�ı��Ŀ�ʼλ��
	 * @param length:��ʾ��ǰ�ı����ݵĳ���
	 * 
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		sb.append(new String(ch,start,length));
		
	}
}
