package com.wk.array;


/**
 * 冒泡排序原理：依次比较相邻的两个数，
 * 较小数放前面，直到最后最大数放在最后，
 * 然后重复操作，最后排序为降序
 * 
 * 第一层循环为重复的次数，循环次数为array.length-1
 * 第二次循环为依次比较相邻的数，循环次数为array.length-1-i
 * 
 * 共比较n*(n-1)/2次，所以O(n)=n*n
 * @author asus
 *
 */


public class PubbleSort {
	
	
	
	public static void main(String[] args) {
		int x;
		int arr[] = new int[]{2,8,5,9,3};
		for(int i=0;i<arr.length-1;++i){
			for(int j=0;j<arr.length-i-1;++j){
				if(arr[j]<arr[j+1]){
					x=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=x;
				}
			}
		}
		for(int num : arr){
			System.out.print(num+" ");
		}
	}
}
