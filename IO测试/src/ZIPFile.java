

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
	
	
	//ѹ���ļ�
	public static void zipFile() throws IOException{
		//��ȡ�ļ�
		InputStream is = new FileInputStream("./src/wk1");
	
		//���ļ��������װΪһ��ZipOutputStream����
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("./src/wk1.zip"));
		//����һ��zip�ļ��е�ʵ��
		zos.putNextEntry(new ZipEntry("wk1.txt"));
		
		int len =-1;
		while((len = is.read()) != -1){
			
			zos.write(len);
		}
		
		is.close();
		zos.close();
	}
	
	//��ѹ�ļ�
	
	public static void unzipFile() throws IOException{
		
		//��ȡ��ѹ�ļ�ѡ��һ��ʵ�岢��װΪһ��������
		ZipFile zipFile = new ZipFile("./src/wk1.zip");
		InputStream is = zipFile.getInputStream(new ZipEntry("wk1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"gbk"));
		
		//��ѹ���ļ����λ��
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
