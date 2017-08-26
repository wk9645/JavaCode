package 线程测试;
/**
 * 
 * @author asus
 * 多线程间通信
 *
 * 该测试实现添加一个数据后然后将该数据打印
 * 使用多线程实现
 *
 */


class Res{
	private String name;
	private String sex;
	private boolean flag= false;
	public synchronized void set(String name,String sex) {
		
		//当flag为真，输入线程等待，不进行设值操作，
		//当flag为假，进行设值，并将flag反转，唤醒输出线程
		if (flag) 
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			this.name = name;
			this.sex = sex;
			flag =true;
			this.notify();
		
	}
	//当flag为假，输出线程等待，不进行输出操作，
	//当flag为真，打印数据，然后将flag反转，唤醒输入线程
	public synchronized void out(){
		if (!flag) 
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println(name+"--->"+sex);
			flag = false;
			this.notify();
			
		
	}
	
}

//输入部分
class Input implements Runnable{
	int x=0;
	Res res;
	public Input(Res res) {
		this.res = res;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true)
		{
			if(x==0)
				res.set("小明", "男");
			else
				res.set("小红", "女");
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
		// TODO 自动生成的方法存根
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		new Thread(new Output(res)).start();
	}
}
