package �̲߳���;
/**
 * 
 * @author asus
 * ���̼߳�ͨ��
 *
 * �ò���ʵ�����һ�����ݺ�Ȼ�󽫸����ݴ�ӡ
 * ʹ�ö��߳�ʵ��
 *
 */


class Res{
	private String name;
	private String sex;
	private boolean flag= false;
	public synchronized void set(String name,String sex) {
		
		//��flagΪ�棬�����̵߳ȴ�����������ֵ������
		//��flagΪ�٣�������ֵ������flag��ת����������߳�
		if (flag) 
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			this.name = name;
			this.sex = sex;
			flag =true;
			this.notify();
		
	}
	//��flagΪ�٣�����̵߳ȴ������������������
	//��flagΪ�棬��ӡ���ݣ�Ȼ��flag��ת�����������߳�
	public synchronized void out(){
		if (!flag) 
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			System.out.println(name+"--->"+sex);
			flag = false;
			this.notify();
			
		
	}
	
}

//���벿��
class Input implements Runnable{
	int x=0;
	Res res;
	public Input(Res res) {
		this.res = res;
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true)
		{
			if(x==0)
				res.set("С��", "��");
			else
				res.set("С��", "Ů");
			x = (1+x)%2;
		}
	}
}

class Output implements Runnable{
	Res res;
	public Output(Res res) {
		this.res = res;
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true)
		{
			res.out();
		}
	}
}
public class ThreadCommu {
	
	public static void main(String[] args) {
		Res res = new Res();
		new Thread(new Input(res)).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		new Thread(new Output(res)).start();
	}
}
