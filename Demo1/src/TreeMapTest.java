import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * 
 * 输入一个字符串，打印每个字符以及出现的次数并使字符倒序排序
 * 输出格式为：字符(次数)字符(次数)...
 * 
 * 思路：（1）将字符串中的字符存到一个数组中，然后对数组遍历，如果当前元素在TreeMap中不存在
 * 		那么添加进去，并将该元素和其出现次数作为一对键值对；如果当前元素已存在，定义一个
 * 		累加器，在已存在次数基础上自加一次再存入TreeMap中，由于key值相同，所以以前的
 * 		记录将会被更新，第一种情况也是如此，只不过累加器是从零开始的。最后按照给定格式取出
 * 		存在Map中的元素。
 * 		（2）创建比较器自定义比较规则
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

//定义一个比较器，使字符按照原有顺序的倒序排列
class Compare implements Comparator<Object>{

	@Override
	public int compare(Object obj1,Object obj2) {
		// TODO 自动生成的方法存根
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
		throw new RuntimeException("类型不匹配");
	}
}
