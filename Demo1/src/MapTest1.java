import java.util.HashMap;
import java.util.Iterator;

/*
 * Map之间的嵌套
 */

public class MapTest1 {
	
	public static void main(String[] args) {
		
		HashMap<String,HashMap<Integer,String>> school = new HashMap<String,HashMap<Integer,String>>();		
		HashMap<Integer,String> class1 = new HashMap<>();
		HashMap<Integer,String> class2 = new HashMap<>();
		
		school.put("普通班", class1);
		school.put("火箭班", class2);
		
		class1.put(1, "张三");
		class1.put(2, "李四");
		
		class2.put(1, "王五");
		class2.put(2, "赵六");
		
		Iterator<String> it1 = school.keySet().iterator();
		
		while(it1.hasNext()){
			
			String cla = it1.next();//取班级的key
			HashMap<Integer, String> claMap = school.get(cla);//取班级的值
			System.out.println(cla);
			Iterator<Integer> it2 = claMap.keySet().iterator();
			while(it2.hasNext()){
				int num = it2.next();
				String name = claMap.get(num);
				System.out.println(num+"::"+name);
			}
		}
	}
}
