package ������;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * ����ͨ��udp���䷽ʽ����һ���������ݷ��ͳ�ȥ
 * 
 * ���裺
 * 1������udp����
 * 2���ṩ���ݣ��������ݷ�װ�����ݰ���
 * 3��ͨ��socket����ķ��͹��ܣ������ݰ����ͳ�ȥ
 * 4���ر���Դ
 * 
 */
public class UdpSend {
	
	public static void main(String[] args) throws Exception {
		//����DatagramSocket����ָ�����Ͷ˶˿ں�
		DatagramSocket socket = new DatagramSocket(5000);   
		//����InetAddress���getByName����,ͨ��ָ������������ȡ���ն�IP��ַ
		InetAddress address = InetAddress.getByName("192.168.2.101");
        //ָ�����͵�����
		String str = "hello world!";
		byte[] buff = str.getBytes();
		//�����ݷ�װ��DatagramPacket�����У���ָ�����ն˵�IP��ַ�Ͷ˿ںţ�Ȼ����
		DatagramPacket packet = new DatagramPacket(buff, buff.length,address,8255);
		socket.send(packet);
		if(socket!=null)
			socket.close();
	}
}
