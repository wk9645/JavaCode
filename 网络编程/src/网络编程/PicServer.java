package ������;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * �ϴ�ͼƬ
 * 
 */


public class PicServer {

	public static void main(String[] args) throws Exception {
		
		
		//��ȡ��������������������Ϊһ���ļ�д��
		ServerSocket ss = new ServerSocket(10008);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream("F:\\wk\\banana2.jpg");
		byte[] buf = new byte[1024];
		int len=0;
		System.out.println("������");
		int i=0;
		while((len = is.read(buf))!= -1){
			fos.write(buf,0,len);
			System.out.println(i++);
		}
		
		System.out.println("�������");
		OutputStream os = socket.getOutputStream();
		os.write("�ϴ��ɹ�".getBytes());
		
		System.out.println("�ѷ���");
		
		
		fos.close();
		ss.close();
		socket.close();
		
	}
	
}
