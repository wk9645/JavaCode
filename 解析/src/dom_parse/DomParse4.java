package dom_parse;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*
 * 写一个document文档，并将其进行增删改
 * 
 */

public class DomParse4 {

	public static void main(String[] args) throws Exception {
//		writeXML();
		modifyXML();
	}
	
	public static void writeXML() throws Exception{
		
		Document doc = DocumentHelper.createDocument();
		//增加一个根标签
		Element rootElem = doc.addElement("students");
		//增加子标签
		Element stuElem = rootElem.addElement("student");
		stuElem.addAttribute("id", "001");
		//添加name标签
		Element nameElem = stuElem.addElement("name");
		nameElem.setText("张三");
		//添加gender标签
		Element gendElem = stuElem.addElement("gender");
		gendElem.setText("男");
		//添加class标签
		Element classElem = stuElem.addElement("class");
		classElem.setText("Java班");
	
		
		FileOutputStream fis = new FileOutputStream(new File("./src/student.xml"));
		XMLWriter writer = new XMLWriter(fis,OutputFormat.createPrettyPrint());
		writer.write(doc);
		if(writer!=null)
			writer.close();
	}
	
	//修改xml文件
	public static void modifyXML() throws Exception{
		Document doc = new SAXReader().read(new File("./src/person.xml"));
		Element rootElem = doc.getRootElement();
		//修改第一个person的名字
		Element per1Elem = (Element)rootElem.elements("person").get(0);
		Element nameElem = per1Elem.element("name");
//		nameElem.setText("王五");
		//修改第二个person的属性
		Element per2Elem = (Element)rootElem.elements("person").get(1);
		per2Elem.attribute("id").setValue("008");
		
		//1、删除第一个person标签，子元素全部删除
		per1Elem.detach();
		
		//恢复name
//		per1Elem.addElement("name").setText("张三");;
		
		//2、删除第二个person的age标签
//		Element ageElem = per2Elem.element("id");
//		ageElem.getParent().remove(ageElem);
//		
		//恢复id
//		per2Elem.addElement("age").setText("20");
		
		FileOutputStream fis = new FileOutputStream(new File("./src/person.xml"));
		XMLWriter writer = new XMLWriter(fis,OutputFormat.createPrettyPrint());
		writer.write(doc);
		if(writer!=null)
			writer.close();
	}
}
