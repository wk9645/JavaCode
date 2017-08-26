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
 * 使用dom4j解析一个xml文件
 */

public class DomParse2 {
	public static void main(String[] args) throws Exception {
		parseWithDom4j();
	}
	
	public static void parseWithDom4j() throws Exception{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/person.xml"));
		StringBuffer sb = new StringBuffer();
		//获取根标签
		Element e = doc.getRootElement();
		getChildNode(e,sb);
		System.out.println(sb.toString());
	
	}

	public static void getChildNode(Element e,StringBuffer sb) {
		
		sb.append("<"+e.getName());
		
		//获取标签属性
		List<Attribute> attrs = e.attributes();
		if(attrs!=null){
			for(Attribute attr : attrs){
				sb.append(" "+attr.getName()+"=\""+attr.getValue()+"\"");
			}
		}
		//开始标签结束
		sb.append(">");
		
		Iterator<Node> it = e.nodeIterator();
		while(it.hasNext()){
			Node node = it.next();
			//如果是标签
			if(node instanceof Element){
				Element elem = (Element)node;
				getChildNode(elem, sb);
			}
			//如果是文本
			if(node instanceof Text){
				Text text = (Text)node;
				//添加文本
				sb.append(text.getText());
			}
		}	
		//结束标签
		sb.append("</"+e.getName()+">");
		
	}
	
}
