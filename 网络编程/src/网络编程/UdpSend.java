package 网络编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 需求：通过udp传输方式，将一段文字数据发送出去
 * 
 * 步骤：
 * 1、建立udp服务
 * 2、提供数据，并将数据封装到数据包中
 * 3、通过socket服务的发送功能，将数据包发送出去
 * 4、关闭资源
 * 
 */
public class UdpSend {
	
	public static void main(String[] args) throws Exception {
		//创建DatagramSocket对象指定发送端端口号
		DatagramSocket socket = new DatagramSocket(5000);   
		//调用InetAddress类的getByName方法,通过指定主机名来获取接收端IP地址
		InetAddress address = InetAddress.getByName("192.168.2.101");
        //指定发送的数据
		String str = "hello world!";
		byte[] buff = str.getBytes();
		//将数据封装到DatagramPacket对象中，并指定接收端的IP地址和端口号，然后发送
		DatagramPacket packet = new DatagramPacket(buff, buff.length,address,8255);
		socket.send(packet);
		if(socket!=null)
			socket.close();
	}
}
