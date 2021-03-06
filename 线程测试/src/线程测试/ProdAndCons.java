package 线程测试;
/*
 * 
 * 生产者和消费者模式
 * 
 * 当生产者和消费者唯一时使用if语句
 * 判断标志位，然后结合等待唤醒机制
 * 来交替实现数据的添加和删除
 * 
 * 当生产者和消费者不唯一时，此时上面的方法
 * 会出现安全问题，此时应该使用while语句
 * 使得线程每次被唤醒时都要进行判断，由于这可能
 * 会导致所有的线程处于等待状态，所以每次操作后
 * 都应该唤醒所有的线程
 * 
 */

class Resource{
		
	private String name;
//	private int count = 0;
//	private static final String PACKAGE = "package" ;
	private boolean flag = false;
	public synchronized void set(String name){
		
		//当flag为真，输入线程等待，不进行设值操作，
		//当flag为假，进行设值，并将flag反转，唤醒输出线程
		while(flag) 
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		this.name = name;
		System.out.println(Thread.currentThread().getName()+"-->in"+this.name);
		flag =true;
		this.notifyAll();
	}
	
	public synchronized void out(){
		
		while(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"-->out"+this.name);
		flag = false;
		this.notifyAll();
	}
}

class Producer implements Runnable{
	Resource res;
	public Producer(Resource res)
	{
		this.res = res;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (true) {
			res.set("\t"+"Package");
		}
	}
	
}


class Consumer implements Runnable{
	Resource res;
	public Consumer(Resource res) {
		this.res = res;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (true) {
			res.out();
		}
	}
}


public class ProdAndCons {
	public static void main(String[] args) {
		
		Resource res = new Resource();
		Producer p = new Producer(res);
		Consumer c = new Consumer(res);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(c);
		Thread t4 = new Thread(c);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
}

