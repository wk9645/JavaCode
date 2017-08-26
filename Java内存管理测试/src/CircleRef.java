import org.junit.Test;

public class CircleRef {
	
	public Object value = null;
	
	private static final int  _1MB = 1024 * 1024;
	
	
	/*
	  	-XX:+PrintGC 输出GC日志
		-XX:+PrintGCDetails 输出GC的详细日志
		-XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）
		-XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800	）
		-XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
		-Xloggc:../logs/gc.log 日志文件的输出路径
	 */
	//为了使回收前后的内存有明显的变化，创建一个1MB的数组
	private byte[] bs = new byte[2* _1MB];
	
	@Test
	public void test(){
		
		CircleRef c1 = new CircleRef();
		CircleRef c2 = new CircleRef();
		
		c1.value = c2;
		c2.value = c1;
		
		c1 = null;
		c2 = null;
		
		//手动回收垃圾
		System.gc();
		
	}
	
	
}
