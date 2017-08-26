import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 将一个文件夹下的所有指定后缀名的文件存到一个文件列表中
 * 
 */


public class FileList {

	public static void main(String[] args) {
		
		List<File> list = new ArrayList<File>();
		File dir = new File("F:\\wk");
		fileToList(dir, list);
		System.out.println("文件个数："+list.size());
		//创建列表文件路径
		File file = new File(dir,"filelist.txt");
		writeToFile(list,file.toString());
		
//		System.out.println("添加成功");
	}
	
	public static void fileToList(File dir,List<File> list){
		
		File[] files = dir.listFiles();
		//遍历当前的对象是一个文件还是一个目录，如果是目录则进入，
		//如果是文件且后缀名为.java则添加到列表中		
		for(File file : files){
			if(file.isDirectory())
				fileToList(dir, list);
			else{
				if(file.getName().endsWith(".java"))
				list.add(file);
			}
		}
	}
	
//	将得到的文件名写到一个文件列表中
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
