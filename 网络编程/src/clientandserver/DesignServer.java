package clientandserver;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 * 自定义服务端
 * 
 */
public class DesignServer {

	public static void main(String[] args) throws Exception{
		
		ServerSocket ss = new ServerSocket(11000);
		Socket socket = ss.accept();
		String ip = InetAddress.getLocalHost().getHostAddress();
		
		InputStream is = socket.getInputStream();
		
		byte[] buf = new byte[1024];
		int len= is.read(buf);
		System.out.println(new String(buf,0,len));
		
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
//							(socket.getOutputStream()));
		
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("<font size='7' color='red'>这是一个自定义的服务器！</font>");
		ps.close();
		
//		bw.write("<font size='7' color='red'>nihao</font>");
//		bw.newLine();
		ss.close();
//		bw.close();
		
	}
	
}
