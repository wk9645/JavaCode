import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ����һ���ļ�
 * 
 */
public class FileCopy {
	
	public static void main(String[] args){
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("F:\\wk\\Test.java");
			fw = new FileWriter("F:\\wk\\Test2.java");
			int len = 0;
			char[] ch = new char[1024];
			while((len=fr.read(ch))!= -1){
				fw.write(new String(ch));
			}
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			if(fr!=null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
		}
		
	}
	
}
