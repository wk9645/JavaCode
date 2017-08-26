package com.sax_parse;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* 
 * 使用SAX解析,将xml文件打印出来
 *
 */


public class SAXParse1 {
	public static void main(String[] args) throws Exception {
		parsewithSAX();
	}
	
	public static void parsewithSAX() throws Exception, SAXException{
		
		//创建SAXParser对象
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		MyDefaultHandler handler = new MyDefaultHandler();
		parser.parse(new File("./src/person.xml"), handler);
		
		String content = handler.getContent();
		System.out.println(content);
		
	}
}



/*
 * 
 * 自定义SAX事件处理器，实现五个解析方法
 * 
 */
class MyDefaultHandler extends DefaultHandler{

	private StringBuffer sb = new StringBuffer();
	
	public String getContent(){
		return sb.toString();
	}
	
	/**
	 * @param qName:开始标签的标签名
	 * @param attributes:属性列表
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		sb.append("<"+qName);
		//判断是否有属性
		if(attributes != null){
			for(int i=0;i<attributes.getLength();i++){
				//得到属性名
				String attrName = attributes.getQName(i);
				String attrValue = attributes.getValue(i);
				sb.append(" "+attrName+"=\""+attrValue+"\"");
			}
		}
		
		sb.append(">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//结束标签
		sb.append("</"+qName+">");
		
	}

	
	/**
	 * @param ch:表示读到之前的所有文本内容
	 * @param start:表示当前文本的开始位置
	 * @param length:表示当前文本内容的长度
	 * 
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		sb.append(new String(ch,start,length));
		
	}
}
