package ���ϲ���;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
	
	public static void main(String[] args) {
		
	ArrayList<String> a = new ArrayList<String>();

	ArrayList<String> b = new ArrayList<String>();
			a.add("one");
			a.add("two");
			a.add("three");
			a.add("five");
			
			
			//��ӡ���Iterator�������
			for(Iterator iterator = a.iterator(); iterator.hasNext();)
			{
				System.out.println(iterator.next());
			}
			
			
			//System.out.println(a);
	
			
		/*	b.add("one");
			b.add("two");
			b.add("three");
			b.add("four");*/
			
			a.retainAll(b);

			//System.out.println(b);
			
	}
	
	

}
