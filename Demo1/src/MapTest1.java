import java.util.HashMap;
import java.util.Iterator;

/*
 * Map֮���Ƕ��
 */

public class MapTest1 {
	
	public static void main(String[] args) {
		
		HashMap<String,HashMap<Integer,String>> school = new HashMap<String,HashMap<Integer,String>>();		
		HashMap<Integer,String> class1 = new HashMap<>();
		HashMap<Integer,String> class2 = new HashMap<>();
		
		school.put("��ͨ��", class1);
		school.put("�����", class2);
		
		class1.put(1, "����");
		class1.put(2, "����");
		
		class2.put(1, "����");
		class2.put(2, "����");
		
		Iterator<String> it1 = school.keySet().iterator();
		
		while(it1.hasNext()){
			
			String cla = it1.next();//ȡ�༶��key
			HashMap<Integer, String> claMap = school.get(cla);//ȡ�༶��ֵ
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
