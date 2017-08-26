import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * 
 * 当一个程序使用次数超过限定次数时就不能再使用
 * 
 */
public class RunCount {

	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		
		File file = new File("F:\\wk\\count.txt");
		if(!file.exists())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);//加载输入流
		
		int count=0;
		String value = prop.getProperty("times");
		if(value!= null){
			count = Integer.parseInt(value);
			if(count>=4){
				System.out.println("免费试用次数已达上限，请付费后再使用！");
				return ;
			}
		}
		count++;
		prop.setProperty("times", count+"");
		
		//将读到的输入流写入输出流
		FileOutputStream fos = new FileOutputStream(file);
		prop.store(fos, "wk");
		fis.close();
		fos.close();
	}
}
