package test2;

/*
 * 选择排序
 * 
 * (1)简单选择排序
 * 
 * 算法：在序列中选出最小的数与第一个位置的数交换，将这个数固定在有序部分，
 * 		然后在剩下的无序部分中找出最小的数与其第一个数交换，依次类推，直至
 * 		所有的数都排好序
 * 
 */
public class Test2 {
	public static void selectSort(int arr[]) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length; ++j) {

				if (arr[i] > arr[j]) {

					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}

		}

	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		int arr[] = new int[]{4,6,3,9,5};
		selectSort(arr);
		for(int num : arr){
			System.out.print(num);
		}
	}
}
