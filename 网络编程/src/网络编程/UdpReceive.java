package ������;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {

	public static void main(String[] args) throws Exception{
		//����DatagramSocket����ָ�����ն˶˿ں�
		DatagramSocket socket = new DatagramSocket(8255);
		//�����յ����ݴ���DatagramPacket������
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf,buf.length);
		socket.receive(packet);
		
		//ʹ��DatagramPacket�еķ�������ȡ���Ͷ˵�IP��ַ�Ͷ˿ں�
		String ip = packet.getAddress().getHostAddress();
		int port = packet.getPort();
		String data = new String(packet.getData(), 0, packet.getLength());
		System.out.print("�����ǣ�"+data+"ip�ǣ�"+ip+"�˿��ǣ�"+port);
		socket.close();
	}
	
}
