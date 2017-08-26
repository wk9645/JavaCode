package ÍøÂç±à³Ì;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpConnectionTest {

	public static void main(String[] args) throws Exception {
//		String urlStr = "http://www.baidu.com";
		String urlStr = "http://192.168.238.2:8080/myweb/wk.html";
		URL url = new URL(urlStr);
		URLConnection connection = url.openConnection();
		
		InputStream is = connection.getInputStream();
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		System.out.println(new String(buf,0,len));
	}
	
}
