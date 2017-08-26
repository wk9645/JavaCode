package dom_parse;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 将xml文件解析并将数据存在一个对象中
 * 
 * 
 */
public class DomParse3 {
	
	
	public static void main(String[] args) throws Exception {
		toObject();
	}
	
	public static void toObject() throws Exception{
		
		List<Person> persons = new ArrayList<>();
		
		SAXReader reader = new SAXReader();
		Document doc =  reader.read(new File("./src/person.xml"));
		
		Element elem = doc.getRootElement();
		
		Iterator<Element> it = elem.elementIterator();
		while(it.hasNext()){
			Person person = new Person();
			Element element = it.next();
		
			person.setId(element.attributeValue("id"));
			person.setName(element.element("name").getText());
			person.setAge(Integer.parseInt(element.element("age").getText()));
			
			persons.add(person);
		}
		for(Person p : persons){
			System.out.println(p.toString());
		}
	}
}
