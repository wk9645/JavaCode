package com.niuke;


/*
 * 问题：把一个数组最开始的若干个元素搬到数组的末尾，称之为数组的旋转，
 * 		输入一个非递减排序的数组的一个旋转，求出旋转数组的最小元素。
 * 		例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的
 * 		最小值为1。NOTE:给出所有的元素都大于0，若数组大小为0请返回0
 * 
 * 思路：得到的旋转数组分为两个子数组，前面的子数组为递增数组A，后面的
 * 		数组为递减数组B，且两个数组以B数组的第一个元素也就是最小元素
 * 		隔开，因此使用二分查找，时间复杂度为O(log(n))
 * 
 * 未完。。。。
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
