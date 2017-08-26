package test3;

/*
 * 
 * 3、交換排序
 * 
 */


public class Test3 {
	
	
	
	/**
	 * 
	 * 冒泡排序
	 * 
	 * 原理：依次比较相邻的两个数，
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
	public static void bubbleSort(int[] arr){
		
		int x;
		for(int i=0;i<arr.length-1;++i){
			for(int j=0;j<arr.length-i-1;++j){
				if(arr[j]>arr[j+1]){
					x=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=x;
				}
			}
		}
	}
		
		
	/*
	 * 
	 * 快速排序: 在序列中选择一个基准元素，创建两个指针head和end分别指向
	 * 			序列的头和尾
	 * 
	 */
	
	public static int qSort(int[] arr, int head, int end){ 
	
		int base = arr[end];
		
		while(head < end){
			
			for(; head<end; head++){
				if(arr[head] > base){
					arr[end] = arr[head];
					break;
				}
			}
			for(; head<end; end--){
				if(arr[end] < base){
					arr[head] = arr[end];
					break;
				}
			}
		}
		arr[end] = base;
		return end;
		
	}
	
	public static void quickSort(int[] arr, int head, int end){
		
		if(head < end){
			int index = qSort(arr, head, end);
			quickSort(arr, head, index-1);
			quickSort(arr, index+1, end);
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = new int[]{2,8,5,9,3};
//		bubbleSort(arr);
		quickSort(arr,0,arr.length-1);
		
		for(int num : arr){
			System.out.print(num+" ");
		}
	}
}