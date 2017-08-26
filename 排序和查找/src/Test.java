import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

public class Test {

	
	public static void main(String[] args) {
		
		int[] arr = new int[]{4,7,1,8,3,9,2,6,5};
		
		//1、冒泡排序
//		puppleSort(arr);
		
		//2、简单选择排序
//		select(arr);
		
		//3、直接插入排序
//		insert(arr);
		
		//4、快速排序
//		sort(arr, 0, arr.length-1);
		
		//5、希尔排序
//		shell(arr);
		
		//6、归并排序
		merge(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	/*
	 * 1、冒泡排序
	 */
	public static void puppleSort(int[] arr){
		
		for(int i=0; i<arr.length - 1; i++){
			for(int j=0; j<arr.length - i - 1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
					
			}
		}
	}
	
	/*
	 * 2、简单选择排序
	 */
	public static void select(int[] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i]>arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	/*
	 * 3、直接插入排序
	 */
	
	public static void insert(int[] arr){
		for(int i=1; i<arr.length; i++){
			int j = 0;
			int temp = arr[i];
			for(j=i; j>0; j--){
				if(temp > arr[j-1])
					break;
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
			/*j=i;
			while(j>0 && temp < arr[j-1]){
				
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;*/
		}
	}
	
	/*
	 * 4、快速排序
	 */
	public static int quickSort(int[] arr, int front, int back){
		int base = arr[back];
		while(front < back){
			for(; front<back; front++){
				if(arr[front] > base){
					arr[back] = arr[front];
					break;
				}
			}
			for(; front<back; back--){
				if(arr[back] < base){ 
					arr[front] = arr[back];
					break;
				}
			}
		}
		arr[back] = base;
		return back;
	}
	
	
	public static void sort(int[] arr,int front,int back ){
		int index = quickSort(arr, front, back);
		if(front<back){
			sort(arr, index+1, back);
			sort(arr, front, index-1);
		}
	}
	
	
	/*
	 * 5、希尔排序
	 */
	public static void shell(int arr[]){
		
		if(arr == null || arr.length < 0){
			return;
		}
		
		//计算增量
		int h = 1;
		while(h < arr.length / 3){
			h = h * 3 + 1;
		}
		
		while(h>0){
			
			int temp = 0;
			int j = 0;
			for(int i=h; i<arr.length; i+=h){
				temp = arr[i];
				j = i;
				while(j>0 && temp < arr[j-h]){
					arr[j] = arr[j-h];
					j-=h;
				}
				arr[j] = temp;
			}
			//缩小增量
			h = (h-1)/3;
		}
	}
	
	/*
	 * 6、归并排序
	 */
	public static void mergeSort(int arr[], int lFirst, int lLast, int rLast){
		//创建一个临时数组
		int tempArr[] = new int[arr.length];
		//临时数组索引
		int tempIndex = lFirst;
		//右数组第一个值
		int rFirst = lLast + 1;
		//保存左数组第一个索引值
		int lFirstPre = lFirst;
		// 对两数组的元素依次进行比较
		while(lFirst <= lLast && rFirst <= rLast){
			if(arr[lFirst] <= arr[rFirst])
				tempArr[tempIndex++] = arr[lFirst++];
			else
				tempArr[tempIndex++] = arr[rFirst++];
		}
		// 然后将其中的一个数组的剩余元素复制到临时数组中
		// 如果是左数组
		while(lFirst<=lLast){
			tempArr[tempIndex++] = arr[lFirst++];
		}
		//如果是右数组
		while(rFirst<=rLast){
			tempArr[tempIndex++] = arr[rFirst++];
		}
		//将元素复制到原数组
		while(lFirstPre<=rLast){
			arr[lFirstPre] = tempArr[lFirstPre++];
		}
		
	}

	
	public static void mSort(int arr[], int left, int right){
		if(left<right){
			//计算中间索引
			int center = (left + right) >> 1;
			//左数组排序
			mSort(arr, left, center);
			//右数组排序
			mSort(arr, center+1, right);
			//二路合并
			mergeSort(arr, left, center, right);
		}
	}
	
	public static void merge(int arr[]){
		mSort(arr, 0, arr.length-1);
	}
}
