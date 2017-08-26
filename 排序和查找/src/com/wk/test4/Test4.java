package com.wk.test4;

/*
 * 
 * πÈ≤¢≈≈–Ú
 * 
 * 
 */
public class Test4 {

	
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,4,8,1,9,5,2,7,6};
		sort(arr);
	}
	
	public static void sort(int[] arr){
		mergeSort(arr, 0, arr.length-1);
	}
	
	public static void mergeSort(int arr[],int left,int right){
		
		if(left < right){
		
			int center = (left + right) >>1;
			mergeSort(arr, left, center);
			mergeSort(arr, center+1, right);
		
			merge(arr, left, center, right);
			print(arr);
		}
		
	}
	public static void print(int[] arr){
		
		for(int item : arr){
			System.out.print(item);
		}
		System.out.println();
		
	}
	
	public static void merge(int[] arr, int lFirst, int lLast, int rLast){
		
		int rFirst = lLast+1;
		int tempArr[] = new int[arr.length];
		int temp = lFirst;
		int lFirstPre = lFirst;
		
		while(lFirst <= lLast && rFirst <= rLast){
			
			if(arr[lFirst] <= arr[rFirst])
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
