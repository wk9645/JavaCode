package dom_parse;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/*
 * ʹ��xPath��������Ԫ��
 * 
 */
public class DomParse5 {

	public static void main(String[] args) throws Exception {
		serachwithxPath();
	}
	
	
	public static void serachwithxPath() throws Exception{
		
		Document doc = new SAXReader().read(new File("./src/person.xml"));
		//1��ʹ��/  (����·��)
		String xpath = "/persons";
		
		//2��ʹ��//  ���·��
		xpath = "//name";
		
		//3��ʹ��*  ͨ���
		xpath = "//person/*";
		
		//4��ʹ��[] ��������id
		xpath = "//person[@id]";
		
		List<Node> nodes = doc.selectNodes(xpath);
		for(Node node : nodes){
			
			System.out.println(node);
		}
		
	}
	
}
