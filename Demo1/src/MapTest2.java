
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
 * Map存入对象
 * 
 */
public class MapTest2 {

	public static void main(String[] args) {
		HashMap<String, List<Student>> school = new HashMap<String,List<Student>>();
		List<Student> rClass = new ArrayList<Student>();
		List<Student> nClass = new ArrayList<Student>();
		
		school.put("普通班", nClass);
		school.put("火箭班", rClass);
		
		nClass.add(new Student(1,"王五"));
		nClass.add(new Student(2,"赵六"));
		rClass.add(new Student(1,"张三"));
		rClass.add(new Student(2,"李四"));
		
		Iterator<String> it = school.keySet().iterator();
		while(it.hasNext()){
			String className = it.next();
			List<Student> list = school.get(className);
			System.out.println(className);
			for(Student item : list){
				System.out.println(item.getNum()+"::"+item.getName());
			}
		}
	}
	
}
class Student{
	private String name;
	private int num;
	
	public Student(int num,String name) {
		this.name = name;
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return num;
	}
}
