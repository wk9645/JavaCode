import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * ��һ���ļ����µ�����ָ����׺�����ļ��浽һ���ļ��б���
 * 
 */


public class FileList {

	public static void main(String[] args) {
		
		List<File> list = new ArrayList<File>();
		File dir = new File("F:\\wk");
		fileToList(dir, list);
		System.out.println("�ļ�������"+list.size());
		//�����б��ļ�·��
		File file = new File(dir,"filelist.txt");
		writeToFile(list,file.toString());
		
//		System.out.println("��ӳɹ�");
	}
	
	public static void fileToList(File dir,List<File> list){
		
		File[] files = dir.listFiles();
		//������ǰ�Ķ�����һ���ļ�����һ��Ŀ¼�������Ŀ¼����룬
		//������ļ��Һ�׺��Ϊ.java����ӵ��б���		
		for(File file : files){
			if(file.isDirectory())
				fileToList(dir, list);
			else{
				if(file.getName().endsWith(".java"))
				list.add(file);
			}
		}
	}
	
//	���õ����ļ���д��һ���ļ��б���
	public static void writeToFile(List<File> list,String javalist){
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(javalist));
			for(File file : list){
				br.write(file.getAbsolutePath());
				br.newLine();
				br.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null)
					br.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
