package 网络编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {

	public static void main(String[] args) throws Exception{
		//创建DatagramSocket对象指定接收端端口号
		DatagramSocket socket = new DatagramSocket(8255);
		//将接收的数据存在DatagramPacket对象中
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf,buf.length);
		socket.receive(packet);
		
		//使用DatagramPacket中的方法来获取发送端的IP地址和端口号
		String ip = packet.getAddress().getHostAddress();
		int port = packet.getPort();
		String data = new String(packet.getData(), 0, packet.getLength());
		System.out.print("数据是："+data+"ip是："+ip+"端口是："+port);
		socket.close();
	}
	
}
