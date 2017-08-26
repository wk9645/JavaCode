package com.wk.collection;

import java.util.HashSet;
import java.util.Iterator;

/*
 * HashSet是实现set接口的子类，其底层的数据结构是
 * 哈希表，其存储元素时会通过哈希算法算出一个哈希值，
 * 然后在
 * 
 * 
 */

public class TreeSet {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("one");
		hs.add("two");
		hs.add("three");
		hs.add("four");
		
		for(Iterator<String> it = hs.iterator();it.hasNext();){
			System.out.println(it.next());
		}

	}
}
