import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 
 * 将一个对象保存到文件中
 */
public class SerializableTest {

	public static void main(String[] args)throws IOException, ClassNotFoundException {
		
//		readObject();
		writeObject();
	}
	
	//写入一个对象
	public static void readObject()throws IOException{
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\wk\\person.txt"));
		oos.writeObject(new Person("张三", 14));
		oos.close();
	}
	//读取对象文件
	public static void writeObject() throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\wk\\person.txt"));
		Person p = (Person) ois.readObject();
		System.out.println(p.getAge()+"---"+p.getName()+"---"+p.getSex());
	}
	
}
class Person implements Serializable{
	
	public static final int serialVersionUID  = 255;
	
	private String name;
	transient int age;
	static String sex = "women";
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}

	public String getSex() {
		return sex;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
}