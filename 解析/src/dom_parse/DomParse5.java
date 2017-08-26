package dom_parse;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/*
 * 使用xPath技术查找元素
 * 
 */
public class DomParse5 {

	public static void main(String[] args) throws Exception {
		serachwithxPath();
	}
	
	
	public static void serachwithxPath() throws Exception{
		
		Document doc = new SAXReader().read(new File("./src/person.xml"));
		//1、使用/  (绝对路径)
		String xpath = "/persons";
		
		//2、使用//  相对路径
		xpath = "//name";
		
		//3、使用*  通配符
		xpath = "//person/*";
		
		//4、使用[] 查找属性id
		xpath = "//person[@id]";
		
		List<Node> nodes = doc.selectNodes(xpath);
		for(Node node : nodes){
			
			System.out.println(node);
		}
		
	}
	
}
