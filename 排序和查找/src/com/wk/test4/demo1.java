package com.wk.test4;

import java.util.Arrays;

/*
 * 有两个有序数组A[97,93,87,86],B[99,94,89,85,70]
 * 
 * 合并为一个数组依然有序
 * 
 * 
 */
public class demo1 {
	
	public static void main(String[] args) {
		int[] A = new int[]{97,93,87,86};
		int[] B = new int[]{99,94,89,85,70};
		int[] result = merge(A, B);
		
		multiMergeSort(result, 0, result.length-1);
		
		System.out.println(Arrays.toString(result));
		
	}
	
	
	public static int[] merge(int[] A, int[] B){
		
		int arr[] = new int[A.length + B.length];
		
		int temp = A.length;
		for(int i=0;i<A.length;i++){
			arr[i] = A[i];
		}
		for(int i=0;i<B.length;i++){
			arr[temp++] = B[i];
		}
		return arr;
	}
	
	
		
	public static void multiMergeSort(int arr[],int left,int right){
			
		if(left < right){
		
			int center = (left + right) >>1;
			multiMergeSort(arr, left, center);
			multiMergeSort(arr, center+1, right);
		
			mergeSort(arr, left, center, right);
//			print(arr);
		}
			
	}
	/*public static void print(int[] arr){
		
		for(int item : arr){
			System.out.print(item);
		}
		System.out.println();
			
	}*/
	
	public static void mergeSort(int[] arr, int lFirst, int lLast, int rLast){
		
		int rFirst = lLast+1;
		int tempArr[] = new int[arr.length];
		int temp = lFirst;
		int lFirstPre = lFirst;
		
		while(lFirst <= lLast && rFirst <= rLast){
			
			if(arr[lFirst] >= arr[rFirst])
				tempArr[temp++] = arr[lFirst++];
			else {
				tempArr[temp++] = arr[rFirst++];
			}
		}
		
		
		while(lFirst <= lLast){
			tempArr[temp++] = arr[lFirst++];
		}
		while(rFirst <= rLast){
			tempArr[temp++] = arr[rFirst++];
		}
		
		
		while(lFirstPre <= rLast){
			arr[lFirstPre] = tempArr[lFirstPre++];
		}
		
	}
	
	
}
