package �̲߳���;

public class ThinkAndEat {
	
	
	public static void main(String[] args) {
		
		Action action = new Action();
		
		for(int i=0; i<5; i++){
			new Thread(new Eating(action)).start();
		}
		
		for(int i=0; i<5; i++){
			new Thread(new Thinking(action)).start();
		}
	}
}



class Action{
	
	private static int c = 10;
	private boolean flag = false;
	
	public static final int randomNum = (int)(Math.random()*10/4)+1;
	
	
	public synchronized void thinking(){
	
		while(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		c++;
		System.out.println(Thread.currentThread().getName()+":����˼��"+"\t����ʣ������"+c);
		flag = true;
		this.notifyAll();
	}

	public synchronized void eating(){

		while(!flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		c--;
		System.out.println(Thread.currentThread().getName()+":���ڳԷ�"+"\t����ʣ������"+c);
		flag = false;
		this.notifyAll();
	}
	
}

class Eating implements Runnable{
	
	Action action;
	
	public Eating(Action action){
		this.action = action;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(Action.randomNum*1000);
				action.eating();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class Thinking implements Runnable{
	
	Action action;
	
	public Thinking(Action action){
		this.action = action;
	}
	
	@Override
	public void run() {
	
		while(true){
			try {
				Thread.sleep(Action.randomNum*1000);
				action.thinking();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}





