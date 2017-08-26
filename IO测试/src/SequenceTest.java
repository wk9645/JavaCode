import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/*
 * 
 * ²âÊÔSequenceStream
 */
public class SequenceTest {

	public static void main(String[] args) throws IOException{
		
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(new FileInputStream("F:\\wk\\Test.java"));
		v.add(new FileInputStream("F:\\wk\\Test2.java"));
		v.add(new FileInputStream("F:\\wk\\Test3.java"));
		
		Enumeration<FileInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);//ºÏ²¢Á÷
		FileOutputStream out = new FileOutputStream("F:\\wk\\squence.txt");
		
		byte[] buf = new byte[1024];
		while(sis.read(buf, 0, buf.length)!=-1){
			out.write(buf);
		}
		sis.close();
		out.close();
	}
}
