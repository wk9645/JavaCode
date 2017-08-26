import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/*
 * 
 * �ܵ�������
 */
public class PipeTest {

	public static void main(String[] args) throws IOException {
		
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		pis.connect(pos);
		Write write = new Write(pos);
		Read read = new Read(pis);
		new Thread(write).start();;
		new Thread(read).start();
	}
}

class Write implements Runnable{

	private PipedOutputStream pos;
	Write(PipedOutputStream pos) {
		this.pos = pos;
	}
	
	@Override
	public void run() {
		
		try {
			System.out.println("���5����");
			Thread.sleep(5000);
			pos.write("hahaha".getBytes());
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pos!=null)
				pos.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		
	}
	
}

class Read implements Runnable{

	private PipedInputStream pis;
	Read(PipedInputStream pis) {
		this.pis = pis;
	}
	
	@Override
	public void run() {
		System.out.println("��ȡǰ����");
		byte[] buff = new byte[1024];
		int len=0;
		try {
			len = pis.read(buff);
			System.out.println("��ȡ���");
			System.out.println(new String(buff,0,len));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pis!=null)
				pis.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
}