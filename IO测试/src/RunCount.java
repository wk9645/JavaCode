import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * 
 * ��һ������ʹ�ô��������޶�����ʱ�Ͳ�����ʹ��
 * 
 */
public class RunCount {

	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		
		File file = new File("F:\\wk\\count.txt");
		if(!file.exists())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);//����������
		
		int count=0;
		String value = prop.getProperty("times");
		if(value!= null){
			count = Integer.parseInt(value);
			if(count>=4){
				System.out.println("������ô����Ѵ����ޣ��븶�Ѻ���ʹ�ã�");
				return ;
			}
		}
		count++;
		prop.setProperty("times", count+"");
		
		//��������������д�������
		FileOutputStream fos = new FileOutputStream(file);
		prop.store(fos, "wk");
		fis.close();
		fos.close();
	}
}
