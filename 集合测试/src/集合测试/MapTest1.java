package ���ϲ���;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 *	����ѧ�������ѧ����ַ����Ϊһ����ֵ��
 * 
 */
class Student implements Comparable<Student>{

	private String name;
	private int age;
	public Student(String name,int age) {
		// TODO �Զ����ɵĹ��캯�����
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
		// TODO �Զ����ɵķ������
		return super.toString();
	}
	
	//��дcompareTo�����Զ����������
	@Override
	public int compareTo(Student s) {
		// TODO �Զ����ɵķ������
		int num = new Integer(this.getAge()).compareTo(new Integer(s.getAge()));
		System.out.println(this.name+"-compareTo-"+s.getName());
		if(num == 0)
			return this.getName().compareTo(s.getName()); 
		return num;
	
	}
	
	//��дhashCode����
	@Override
	public int hashCode(){
		// TODO �Զ����ɵķ������
		return name.hashCode()+age*32;
	}
	
	
	//��дequals�����Զ���Ԫ��Ψһ�Ա�׼
	@Override
	public boolean equals(Object obj) {
		// TODO �Զ����ɵķ������
		if(!(obj instanceof Student))
			throw new ClassCastException("���Ͳ�ƥ��");
		Student s = (Student) obj;
		return this.name.equals(s.name)&&this.age == s.age;
	
	}
	
}

public class MapTest1 {
	public static void main(String[] args) {
		Map<Student,String> map = new HashMap<Student,String>();
		map.put(new Student("����", 18), "�Ϻ�");
		map.put(new Student("����", 19), "����");
		map.put(new Student("����", 20), "����");
		
		/*
		//��һ��ȡ����ʽ
		Set<Student> keySet = map.keySet();
		Iterator<Student> it = keySet.iterator();
		
		while(it.hasNext()){
			Student s = it.next();//key
			String attr = map.get(s);
			System.out.println(s.getName()+"-"+s.getAge()+":"+attr);
		}
		*/
		
		//�ڶ���ȡ����ʽ
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
