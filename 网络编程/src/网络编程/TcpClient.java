package 网络编程;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
/*
 * 需求：客户端输入的字符串发送给服务器端，然后将大写格式返回给客户端
 * 
 * TCP客户端，提供输出流
 */
public class TcpClient {

	public static void main(String[] args) throws Exception, IOException {
		
		//创建客户端Socket指定服务器端主机和端口号
		Socket socket = new Socket("127.0.0.1", 5698);
		//获取键盘输入的数据
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		//获取网络输出流，用于向网络上写数据
		OutputStream os = socket.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		//获取网络输入流，用于接收网络数据
		InputStream is = socket.getInputStream();
		BufferedReader br1 = new BufferedReader(new InputStreamReader(is));
		
		/*
		 *	下面代码为读取键盘输入数据
		 *	并将其写入网络流用于服务器
		 *	端的接收，服务器接收到后返回信息
		 *
		 */
		String line = null;
		while((line = br.readLine())!= null){
			if(line.equals("over"))
				break;
			bw.write(line);
			bw.newLine();
			bw.flush();
			String len = br1.readLine();
			System.out.println(len);
		}
		Thread.sleep(5000);
		System.out.println("已收到");
		
		br.close();
		socket.close();
	}
	
}
