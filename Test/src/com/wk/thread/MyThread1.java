package com.wk.thread;

public class MyThread1 implements Runnable{
	 private Integer key = 0;

	    @Override
	    public void run() {
	        // key��Integer����ע�ⲻ��int����Ϊint���Ƕ���
	        // �߳̽�������ͬ������֮ǰ����Ҫ�Ȼ�ȡkey������
	        // ��Ҫ�����keyʵ�������������û��ͬ���飬����ܻ�����ظ�keyֵ������
	        synchronized (key) {
	            key++;
	            
	            System.out.println(Thread.currentThread().getName() + ":" + key);
	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	            }
	        }
	    }

	    public static void main(String[] args) {

	    	MyThread1 mt = new MyThread1();
	        for(int i=0; i<10; i++) {
	            new Thread(mt, "Thread" + i).start();
	        }
	    }
}
