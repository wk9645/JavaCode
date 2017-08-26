package clientandserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * 
 * 自定义浏览器
 * 
 */
public class DesignBrowns {
	
	
	public static void main(String[] args) throws Exception{
		
		Socket socket = new Socket("192.168.238.2", 8080);
		PrintStream out = new PrintStream(socket.getOutputStream(),true);
		out.println("GET /myweb/wk.html HTTP/1.1");
		out.println("*/*");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 192.168.238.2:11000");
		out.println("Connection: closed");
		
		//使用空行将请求头和请求体隔开
		out.println();
		out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = null;
		while((line = br.readLine())!= null){
			System.out.println(line);
		}
		br.close();
		socket.close();
		
		
	}
}
