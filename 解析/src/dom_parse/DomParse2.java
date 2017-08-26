package dom_parse;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;

/*
 * 
 * ʹ��dom4j����һ��xml�ļ�
 */

public class DomParse2 {
	public static void main(String[] args) throws Exception {
		parseWithDom4j();
	}
	
	public static void parseWithDom4j() throws Exception{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/person.xml"));
		StringBuffer sb = new StringBuffer();
		//��ȡ����ǩ
		Element e = doc.getRootElement();
		getChildNode(e,sb);
		System.out.println(sb.toString());
	
	}

	public static void getChildNode(Element e,StringBuffer sb) {
		
		sb.append("<"+e.getName());
		
		//��ȡ��ǩ����
		List<Attribute> attrs = e.attributes();
		if(attrs!=null){
			for(Attribute attr : attrs){
				sb.append(" "+attr.getName()+"=\""+attr.getValue()+"\"");
			}
		}
		//��ʼ��ǩ����
		sb.append(">");
		
		Iterator<Node> it = e.nodeIterator();
		while(it.hasNext()){
			Node node = it.next();
			//����Ǳ�ǩ
			if(node instanceof Element){
				Element elem = (Element)node;
				getChildNode(elem, sb);
			}
			//������ı�
			if(node instanceof Text){
				Text text = (Text)node;
				//����ı�
				sb.append(text.getText());
			}
		}	
		//������ǩ
		sb.append("</"+e.getName()+">");
		
	}
	
}
