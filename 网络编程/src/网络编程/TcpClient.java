package ������;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
/*
 * ���󣺿ͻ���������ַ������͸��������ˣ�Ȼ�󽫴�д��ʽ���ظ��ͻ���
 * 
 * TCP�ͻ��ˣ��ṩ�����
 */
public class TcpClient {

	public static void main(String[] args) throws Exception, IOException {
		
		//�����ͻ���Socketָ���������������Ͷ˿ں�
		Socket socket = new Socket("127.0.0.1", 5698);
		//��ȡ�������������
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		//��ȡ�����������������������д����
		OutputStream os = socket.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		//��ȡ���������������ڽ�����������
		InputStream is = socket.getInputStream();
		BufferedReader br1 = new BufferedReader(new InputStreamReader(is));
		
		/*
		 *	�������Ϊ��ȡ������������
		 *	������д�����������ڷ�����
		 *	�˵Ľ��գ����������յ��󷵻���Ϣ
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
		System.out.println("���յ�");
		
		br.close();
		socket.close();
	}
	
}
