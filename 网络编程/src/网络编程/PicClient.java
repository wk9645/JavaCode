package 网络编程;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 上传图片
 */
public class PicClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 10008);
		FileInputStream fis = new FileInputStream("F:\\wk\\banana.jpg");
		
		OutputStream os = socket.getOutputStream();
			
		//获取图片文件输入流并写入网络流中
		byte[] buf = new byte[1024];
		int len=0;
		while((len = fis.read(buf))!=-1){
			os.write(buf,0,len);
		}
		
		System.out.println("停止");
		
		
		//从网络流获取数据
		
		InputStream is = socket.getInputStream();
		byte[] bufIn = new byte[1024];
		
		int len2 = is.read(bufIn);
		
		System.out.println("返回--->"+new String(bufIn,0,len2));

		fis.close();
		socket.close();
	}
}
