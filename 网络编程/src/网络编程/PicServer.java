package 网络编程;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 上传图片
 * 
 */


public class PicServer {

	public static void main(String[] args) throws Exception {
		
		
		//获取到网络输入流，将其作为一个文件写入
		ServerSocket ss = new ServerSocket(10008);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream("F:\\wk\\banana2.jpg");
		byte[] buf = new byte[1024];
		int len=0;
		System.out.println("发送中");
		int i=0;
		while((len = is.read(buf))!= -1){
			fos.write(buf,0,len);
			System.out.println(i++);
		}
		
		System.out.println("发送完毕");
		OutputStream os = socket.getOutputStream();
		os.write("上传成功".getBytes());
		
		System.out.println("已发送");
		
		
		fos.close();
		ss.close();
		socket.close();
		
	}
	
}
