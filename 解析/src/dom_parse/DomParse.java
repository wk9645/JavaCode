package dom_parse;

import java.io.File;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/*
 * 使用dom4j解析xml文件所有标签
 * 
 * 
 */

public class DomParse {
	
	public static void main(String[] args) throws Exception {
		parsewithdom4j();
	}
	
	public static void parsewithdom4j() throws Exception{
		//创建一个xml解析器对象
		//读取xml文件，返回一个Document对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/person.xml"));
		
		//获取根标签
		
		Element e = doc.getRootElement();
		getChild(e);
	}
	public static void getChild(Element e){ 
		
		String name = e.getName();
		System.out.println(name);
		Iterator<Node> it1 = e.nodeIterator();
		while(it1.hasNext()){
			Node node = it1.next();
			if(node instanceof Element){
				Element elem = (Element)node;
				getChild(elem);
			}
		}
	}
}
