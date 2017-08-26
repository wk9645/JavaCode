

import java.util.Arrays;



public class Sort {

	public static void main(String args[]) {

		int arr[] = new int[] { 6, 7, 1, 9, 4, 8, 2, 5, 3 };
//		shellSort(arr);
		binarySort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * 
	 * 折半排序
	 * 		原理:本质上是直接插入排序,在进行插入操作时,首先在有序序列中进行二分查找,
	 * 			找到可插入的索引后再进行元素后移,然后插入元素
	 * 	
	 */
	public static void binarySort(int arr[]){
		
		for(int i=1;i<arr.length;++i){
			
			//保存当前第i个值
			int temp = arr[i];
			
			//定义两个指针指向已排好序部分的头尾
			int head = 0;
			int end = i-1;
			
		//二分查找,找出不大于temp的索引
		while(head <= end){
			//每一次循环求一次中间值
			int center = (head + end) >> 1;
			if(arr[center] < temp)
				head = center + 1;
			else
				end = center - 1;
		}
		//此时head==end,然后后移
		int j;
		for(j=i-1; j>end; j--){
			arr[j+1] = arr[j];
		}
		//赋值
		arr[j+1] = temp;
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 希尔排序:
	 * 		原理:将整个数组以一个可变的增量为步数分为若干个子数组,然后对
	 * 			各个子数组进行直接插入排序,记为一次循环,然后缩小增量,子
	 * 			数组继续拆分,重复上述操作,直到增量减少为1,即对整个数组
	 * 			进行一次插入排序.
	 * 		时间复杂度:最坏情况为O(n^2),平均为O(nlogn).
	 * 
	 */

	public static void shellSort(int arr[]) {

		if (arr == null || arr.length <= 0) {
			return;
		}

		int h = 1;
		// 计算出最大增量值
		while (h <= arr.length / 3) {
			h = h * 3 + 1;
		}

		while (h > 0) {

			// 以h为增量将整个数组分组,将每组的第一个元素视为已排好序,
			// 从未排好序的第一个元素开始和前面依次比较

			// 第一层循环用于分组
			for (int i = h; i < arr.length; i += h) {
				// 保存未排序部分的一个元素值
				int temp = arr[i];
				while (i > 0 && temp < arr[i - h]) {
					// 后移
					arr[i] = arr[i - h];
					i -= h;
				}
				// 将temp放到空白处
				arr[i] = temp;
			}

			// 计算新的增量
			h = (h - 1) / 3;

		}
	}

}
