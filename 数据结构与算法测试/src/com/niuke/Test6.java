package com.niuke;


/*
 * ���⣺��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ����֮Ϊ�������ת��
 * 		����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * 		��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת���������
 * 		��СֵΪ1��NOTE:�������е�Ԫ�ض�����0���������СΪ0�뷵��0
 * 
 * ˼·���õ�����ת�����Ϊ���������飬ǰ���������Ϊ��������A�������
 * 		����Ϊ�ݼ�����B��������������B����ĵ�һ��Ԫ��Ҳ������СԪ��
 * 		���������ʹ�ö��ֲ��ң�ʱ�临�Ӷ�ΪO(log(n))
 * 
 * δ�ꡣ������
 * 
 */

public class Test6 {

	public int solution(int array[]){
		int firstIndex = 0;
		int lastIndex = array.length-1;
		if (array.length != 0) {
			while(firstIndex == lastIndex-1){
				int midIndex = (lastIndex-firstIndex)/2;
				if(array[midIndex]>array[firstIndex]){
					firstIndex = midIndex+1;
					
				}else{
					lastIndex = midIndex;
				}
			}
			return lastIndex;
		}
		else
			return 0;
	}

	public static void main(String[] args) {
		Test6 t = new Test6();
		int a[] = new int[]{3,4,5,1,2};
		
		int min = t.solution(a);
		System.out.println(min);
	}
	
}
