package chat;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ChatText {
	
	Frame frame;
	Panel p1;
	Panel p2;
	TextArea textEdit;
	TextArea textShow;
	Button send;
	Button clear;
	StringBuffer sb;
	
	//对控件进行初始化
	void init(){
		frame= new Frame("chatting");
		frame.setLayout(new FlowLayout());
		frame.setBounds(300, 200, 500, 500);
		p1 = new Panel();
		p2 = new Panel();
		send = new Button("发送");
		clear = new Button("清屏");
		textEdit = new TextArea("",4,50);
		textShow = new TextArea("",20,60);
		textShow.setEditable(false);
		p1.add(textShow);
		
		//添加输入框和按钮
		p2.add(textEdit);
		p2.add(send);
		p2.add(clear);
		frame.add(p1);
		frame.add(p2);	
	}
			
	public static void main(String[] args) throws SocketException {
		ChatText ct = new ChatText();
		ct.init();
		ct.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		ct.frame.setVisible(true);
		ct.send();
		ct.clear();
		DatagramSocket socket_s = new DatagramSocket(10000);
		DatagramSocket socket_r = new DatagramSocket(10002);
		new Thread(new ChatSend(socket_s)).start();
		new Thread(new ChatRece(socket_r)).start();
	}
	
	
	//发送消息
	public void send(){
		
		//直接回车发送
		textEdit.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent k) {
				super.keyPressed(k);
				
				if(k.getKeyCode() == KeyEvent.VK_ENTER){
					String str = textEdit.getText().toString();
					if(sb == null)
						sb = new StringBuffer();
					sb.append(str);
					textShow.setText(sb.toString()+"\n");
					textEdit.setText(null);
				}
			}
		});

		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = textEdit.getText().toString();
				if(sb == null)
					sb = new StringBuffer();
				sb.append(str+"\n");
				textShow.setText(sb.toString());
				textEdit.setText(null);
			}
		});
	}
	//清屏操作
	public void clear(){
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textShow.setText(null);
				sb = null;
			}
		});
	}
	
}


//发送端
class ChatSend implements Runnable{
	private ChatText cText;
	private DatagramSocket socket;
	public ChatSend(DatagramSocket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		cText = new ChatText();
		InetAddress address;
		try {
			address = InetAddress.getByName("192.168.2.101");
			if(cText.textEdit!=null){
				
			byte[] buf = cText.textEdit.getText().toString().getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length,address,10002);
			socket.send(packet);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
//接收端
class ChatRece implements Runnable{
	  
	private ChatText cText;
	private DatagramSocket Socket;
	public ChatRece(DatagramSocket Socket) {
		this.Socket = Socket;
	}
	@Override
	public void run() {
		cText = new ChatText();
		
		while(true){
			byte[] buf = new byte[1024*4];
			DatagramPacket packet  = new DatagramPacket(buf, buf.length);
			try {
				Socket.receive(packet);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			String ip = packet.getAddress().getHostAddress();	
			String data = new String(packet.getData(), 0, packet.getLength());
	
			cText.textShow.setText(ip+":"+data);
		}
	}
}
