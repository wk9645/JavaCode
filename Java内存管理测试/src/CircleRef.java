import org.junit.Test;

public class CircleRef {
	
	public Object value = null;
	
	private static final int  _1MB = 1024 * 1024;
	
	
	/*
	  	-XX:+PrintGC ���GC��־
		-XX:+PrintGCDetails ���GC����ϸ��־
		-XX:+PrintGCTimeStamps ���GC��ʱ������Ի�׼ʱ�����ʽ��
		-XX:+PrintGCDateStamps ���GC��ʱ����������ڵ���ʽ���� 2013-05-04T21:53:59.234+0800	��
		-XX:+PrintHeapAtGC �ڽ���GC��ǰ���ӡ���ѵ���Ϣ
		-Xloggc:../logs/gc.log ��־�ļ������·��
	 */
	//Ϊ��ʹ����ǰ����ڴ������Եı仯������һ��1MB������
	private byte[] bs = new byte[2* _1MB];
	
	@Test
	public void test(){
		
		CircleRef c1 = new CircleRef();
		CircleRef c2 = new CircleRef();
		
		c1.value = c2;
		c2.value = c1;
		
		c1 = null;
		c2 = null;
		
		//�ֶ���������
		System.gc();
		
	}
	
	
}
