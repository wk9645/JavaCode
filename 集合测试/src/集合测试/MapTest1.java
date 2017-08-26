package 集合测试;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 *	创建学生对象和学生地址，作为一个键值对
 * 
 */
class Student implements Comparable<Student>{

	private String name;
	private int age;
	public Student(String name,int age) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return super.toString();
	}
	
	//重写compareTo方法自定义排序规则
	@Override
	public int compareTo(Student s) {
		// TODO 自动生成的方法存根
		int num = new Integer(this.getAge()).compareTo(new Integer(s.getAge()));
		System.out.println(this.name+"-compareTo-"+s.getName());
		if(num == 0)
			return this.getName().compareTo(s.getName()); 
		return num;
	
	}
	
	//重写hashCode方法
	@Override
	public int hashCode(){
		// TODO 自动生成的方法存根
		return name.hashCode()+age*32;
	}
	
	
	//重写equals方法自定义元素唯一性标准
	@Override
	public boolean equals(Object obj) {
		// TODO 自动生成的方法存根
		if(!(obj instanceof Student))
			throw new ClassCastException("类型不匹配");
		Student s = (Student) obj;
		return this.name.equals(s.name)&&this.age == s.age;
	
	}
	
}

public class MapTest1 {
	public static void main(String[] args) {
		Map<Student,String> map = new HashMap<Student,String>();
		map.put(new Student("张三", 18), "上海");
		map.put(new Student("李四", 19), "西安");
		map.put(new Student("王五", 20), "火星");
		
		/*
		//第一种取出方式
		Set<Student> keySet = map.keySet();
		Iterator<Student> it = keySet.iterator();
		
		while(it.hasNext()){
			Student s = it.next();//key
			String attr = map.get(s);
			System.out.println(s.getName()+"-"+s.getAge()+":"+attr);
		}
		*/
		
		//第二种取出方式
		Set<Map.Entry<Student, String>> set = map.entrySet();
		for(Iterator<Map.Entry<Student, String>> it = set.iterator();it.hasNext();)
		{
			
			Map.Entry<Student, String> entry = it.next();
			Student s = entry.getKey();
			String attr = entry.getValue();
			System.out.println(s.getName()+"-"+s.getAge()+":"+attr);
		}
	}
}
