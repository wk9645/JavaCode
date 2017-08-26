import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/*
 * ����̨����ѧ�����ֺ͸�����Ŀ�ĳɼ�����ѧ���ĳɼ���������Ȼ��浽һ���ļ���
 * 
 * ˼·��1������ѧ�����󣬽���Ϣ��TreeSet���ϴ洢
 * 	    2����TreeSet�е���Ϣд���ļ���
 * 
 */

class Student implements Comparable<Student>{
	private String name;
	private int math,cn,en;
	private int sum;
	public Student(String name,int math,int cn,int en) {
		this.name = name;
		this.math = math;
		this.cn = cn;
		this.en = en;
		sum = math+cn+en;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSum() {
		return sum;
	}
	@Override
	public String toString() {
		return name+"--"+math+"--"+cn+"--"+en;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+sum*65;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Student))
			throw new ClassCastException("���Ͳ�ƥ��");
		Student s = (Student)obj;
		return this.name.equals(s.getName())&&this.sum==s.getSum();
	}

	@Override
	public int compareTo(Student s) {
		int result = new Integer(this.sum).compareTo(new Integer(s.getSum()));
		if(result==0)
			return this.name.compareTo(s.getName());
		return result;
	}
	
}
class StuInfo{
	
	public static TreeSet<Student> getInfo2(){
		return getInfo(null);
	}
	
	public static TreeSet<Student> getInfo(Comparator<Student> cmp) {
		TreeSet<Student> stus;
		if(cmp==null)
			stus = new TreeSet<>();
		else 
			stus = new TreeSet<Student>(cmp);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String line=null;
			while((line=br.readLine())!=null){
				if("over".equals(line))
					break;
				String[] info = line.split(",");//ʹ��","���зָ�
				Student stu = new Student(info[0], Integer.parseInt(info[1]),
						Integer.parseInt(info[2]), Integer.parseInt(info[3]));
				stus.add(stu);
			}
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
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
		return stus;
	}

	
	public static void writeToFile(TreeSet<Student> stus){
			
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("F:\\wk\\stu.txt"));
			for(Student stu : stus){
				bw.write(stu.toString()+"\t");
				bw.write(stu.getSum()+"");
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				if(bw!=null)
					bw.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}

public class BigTest {

	
	public static void main(String[] args) {
		Comparator<Student> cmp = Collections.reverseOrder();
//		TreeSet<Student> stus = StuInfo.getInfo(cmp);
		TreeSet<Student> stus = StuInfo.getInfo2();
		StuInfo.writeToFile(stus);
	}
}
