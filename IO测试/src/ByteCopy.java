import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * 复制一张图片
 * 
 */


public class ByteCopy {
	
	public static void main(String[] args) throws IOException{
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\wk\\banana.jpg"));
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\图片资源\\banana.jpg"));
		
		int len=0;
				
		while((len=bis.read())!=-1){
			bos.write(len);
		}
		if(bos!=null)
			bos.close();
		if(bis!=null)
			bis.close();
	}
	
	
}
