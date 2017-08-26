package ������;
/*
 * TCP��������
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
		
		//������������Socket��ָ���÷������˿ں�
		ServerSocket ss = new ServerSocket(5698);
		//��ȡ�ͻ���Socket����
		Socket socket = ss.accept();
		//��ȡ����������
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//��ȡ���������
		OutputStream os = socket.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		
		//ʹ�ô�ӡ�����
//		PrintStream ps = new PrintStream(os,true);
		
		//��ÿͻ��˷��͵����ݺ���ͻ��˷�������
		String line=null;
		while((line = br.readLine())!=null){

//			ps.println(line.toUpperCase());	
			System.out.println(line);
			bw.write(line.toUpperCase());
			bw.newLine();
			bw.flush();	
		}
		System.out.println("�ѷ���");
		ss.close();
	}
}
