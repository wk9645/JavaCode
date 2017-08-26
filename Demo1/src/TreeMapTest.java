import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * 
 * ����һ���ַ�������ӡÿ���ַ��Լ����ֵĴ�����ʹ�ַ���������
 * �����ʽΪ���ַ�(����)�ַ�(����)...
 * 
 * ˼·����1�����ַ����е��ַ��浽һ�������У�Ȼ�����������������ǰԪ����TreeMap�в�����
 * 		��ô��ӽ�ȥ��������Ԫ�غ�����ִ�����Ϊһ�Լ�ֵ�ԣ������ǰԪ���Ѵ��ڣ�����һ��
 * 		�ۼ��������Ѵ��ڴ����������Լ�һ���ٴ���TreeMap�У�����keyֵ��ͬ��������ǰ��
 * 		��¼���ᱻ���£���һ�����Ҳ����ˣ�ֻ�����ۼ����Ǵ��㿪ʼ�ġ�����ո�����ʽȡ��
 * 		����Map�е�Ԫ�ء�
 * 		��2�������Ƚ����Զ���ȽϹ���
 */

public class TreeMapTest {
	
	public static String charCount(String str){
		
		char[] ch = str.toCharArray();
		TreeMap<Character, Integer> treeMap = new TreeMap<>(new Compare());
		int count = 0;
		for(int i=0;i<ch.length;i++){
			if(!(ch[i]>='a'&&ch[i]<='z'||ch[i]>='A'&&ch[i]<='Z'))
				continue;
			Integer value = treeMap.get(ch[i]);
			if(value!=null)
				count=value;
			count++;
			treeMap.put(ch[i], count);
			count=0;
		}	
		//System.out.println(treeMap);
		
		StringBuffer sb = new StringBuffer();
		Set<Map.Entry<Character, Integer>> set = treeMap.entrySet();
		Iterator<Map.Entry<Character, Integer>> it = set.iterator();
		while(it.hasNext()){
			Map.Entry<Character, Integer> entry = it.next();
			sb.append(entry.getKey()+"("+entry.getValue()+")");
			
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String str = charCount("aababcabcd");
		System.out.println(str);
	}	
	
}

//����һ���Ƚ�����ʹ�ַ�����ԭ��˳��ĵ�������
class Compare implements Comparator<Object>{

	@Override
	public int compare(Object obj1,Object obj2) {
		// TODO �Զ����ɵķ������
		if(!(obj1 instanceof Character)||(obj2 instanceof Character))
		{
			Character ch1 = (Character) obj1;
			Character ch2 = (Character) obj2;
			int result = ch1.compareTo(ch2);
			if(result>0)
				return -1;
			else if(result<0)
				return 1;
			return 0;
		}
		throw new RuntimeException("���Ͳ�ƥ��");
	}
}
