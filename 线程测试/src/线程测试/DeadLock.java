package 线程测试;


/**
 * 
 * @author asus
 *
 * 创建多线程对两个同步代码块进行访问，
 * 这两个同步代码块互相嵌套，使用不同的锁，
 * 当主线程开始运行，两个子线程通过锁来访问
 * 同步代码块，这时有可能会出现死锁的情况
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
		// TODO 自动生成的方法存根
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
