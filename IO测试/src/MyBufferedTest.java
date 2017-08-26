import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*
 * 
 * 自定义MyBufferedReader并实现其readLine方法
 * 
 */
public class MyBufferedTest {
	public static void main(String[] args) throws IOException{
		
		FileWriter fw = new FileWriter("F:\\wk\\demo.txt");
		FileReader fr = new FileReader(new File("F:\\wk\\demo.txt"));
		MyBuffered myBuffered = new MyBuffered(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=1;i<=4;i++){
			bw.write("abcd"+i);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		String line = null;
		while((line=myBuffered.MyReadLine())!=null)
		{
			System.out.println(myBuffered.getLineNumber()+":"+line);
		}
		myBuffered.myClose();
	}
}

class MyBuffered{
	
	private int lineNumber;
	private FileReader reader;
	public MyBuffered(FileReader reader) {
		
		this.reader = reader;
	}
	
	public void setLineNumber(int lineNumber){
	
		this.lineNumber = lineNumber;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	
	public String MyReadLine(){
		
		lineNumber++;
		StringBuffer sb = new StringBuffer();
		try {
			int ch=0;
			while((ch=reader.read())!=-1){
				
				if(ch=='\r')
					continue;
				if(ch=='\n')
					return sb.toString();
				else
					sb.append((char)ch);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		if(sb.length()!=0)
			return sb.toString();
		return null;
	}
	
	public void myClose(){
		try {
			reader.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}