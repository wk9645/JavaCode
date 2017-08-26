package 网络编程;
/*
 * TCP服务器端
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) throws Exception {
		
		//创建服务器端Socket并指定该服务器端口号
		ServerSocket ss = new ServerSocket(5698);
		//获取客户端Socket对象
		Socket socket = ss.accept();
		//获取网络输入流
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//获取网络输出流
		OutputStream os = socket.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		
		//使用打印流输出
//		PrintStream ps = new PrintStream(os,true);
		
		//获得客户端发送的数据后并向客户端返回数据
		String line=null;
		while((line = br.readLine())!=null){

//			ps.println(line.toUpperCase());	
			System.out.println(line);
			bw.write(line.toUpperCase());
			bw.newLine();
			bw.flush();	
		}
		System.out.println("已发送");
		ss.close();
	}
}
