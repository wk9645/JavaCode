package com.wk.testNet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {

	public static void main(String[] args) throws Exception {
		
	Socket socket = new Socket("127.0.0.1", 10001);
		
		//写数据
		OutputStream os = socket.getOutputStream();
		
		
		Admin admin = new Admin();
		admin.setName("美洋洋");
		admin.setPwd("aa");
		
		//写出对象流
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(admin);
		
		//关闭输出流独享
		socket.shutdownOutput();
		
		
		
		//接收服务器响应数据
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		
		
		String len = null;
		while((len = br.readLine()) != null)
			System.out.println("服务器响应：" + len);
			
	}
}
