package �̲߳���;


/**
 * 
 * @author asus
 *
 * �������̶߳�����ͬ���������з��ʣ�
 * ������ͬ������黥��Ƕ�ף�ʹ�ò�ͬ������
 * �����߳̿�ʼ���У��������߳�ͨ����������
 * ͬ������飬��ʱ�п��ܻ�������������
 * 
 *
 */

class Test implements Runnable{
	
	boolean flag;
	
	public Test(boolean flag){
		this.flag = flag;
	}
	static Object ob1 = new Object();
	static Object ob2 = new Object();
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
			if (flag) 
			{
				while(true)
				{
					synchronized (ob1) 
					{
						System.out.println(Thread.currentThread().getName()+" "+"if ob1");
						synchronized (ob2) 
						{
							System.out.println(Thread.currentThread().getName()+" "+"if ob2");
						}
					}
				}
			}
		
		else
		{
			while(true)
			{
				synchronized (ob2) 
				{
					System.out.println(Thread.currentThread().getName()+" "+"else ob2");
					synchronized (ob1) 
					{
						System.out.println(Thread.currentThread().getClass()+" "+"else ob1");
					}
				}
			}
		}
	}
	
}

public class DeadLock {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Test(false));
		Thread thread2 = new Thread(new Test(true));
		thread1.start();
		thread2.start();
	}

}
