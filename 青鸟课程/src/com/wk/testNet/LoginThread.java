package com.wk.testNet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class LoginThread extends Thread{
	
	private Socket socket;
	
	public LoginThread(Socket socket){
		
		this.socket = socket;
		
	}

	@Override
	public void run() {
		
		InputStream is = null;
		ObjectInputStream ois = null;
		OutputStream os = null;
		
		try {
			
			//将获取到的网络输入流转换为一个对象流
			is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			
			//获取Admin对象
			Admin admin = (Admin)ois.readObject();
			
			System.out.println("姓名：" + admin.getName() + "密码：" + admin.getPwd());
			
			//获取ip
			
			InetAddress ia = socket.getInetAddress();

			String ip = ia.getHostAddress();
			System.out.println("登录的主机号为：" + ip);
			
			
			
			
			
			//服务器响应
			
			String response = "succeed";
			os = socket.getOutputStream();
			os.write(response.getBytes());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {
				os.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
}
