package com.wk.collection;

import java.util.HashSet;
import java.util.Iterator;

/*
 * HashSet��ʵ��set�ӿڵ����࣬��ײ�����ݽṹ��
 * ��ϣ����洢Ԫ��ʱ��ͨ����ϣ�㷨���һ����ϣֵ��
 * Ȼ����
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
