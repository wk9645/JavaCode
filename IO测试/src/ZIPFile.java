

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZIPFile {
	
	public static void main(String[] args) throws IOException {
//		zipFile();
		unzipFile();
	}
	
	
	//压缩文件
	public static void zipFile() throws IOException{
		//获取文件
		InputStream is = new FileInputStream("./src/wk1");
	
		//将文件输出流封装为一个ZipOutputStream对象
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("./src/wk1.zip"));
		//创建一个zip文件中的实体
		zos.putNextEntry(new ZipEntry("wk1.txt"));
		
		int len =-1;
		while((len = is.read()) != -1){
			
			zos.write(len);
		}
		
		is.close();
		zos.close();
	}
	
	//解压文件
	
	public static void unzipFile() throws IOException{
		
		//获取解压文件选择一个实体并封装为一个流对象
		ZipFile zipFile = new ZipFile("./src/wk1.zip");
		InputStream is = zipFile.getInputStream(new ZipEntry("wk1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"gbk"));
		
		//解压后文件输出位置
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./src/wk3.txt")));
		String len = null;
		while((len = br.readLine()) != null){
			
			bw.write(len);
			bw.newLine();
		}
		
		br.close();
		bw.close();
		
	}
	
}
