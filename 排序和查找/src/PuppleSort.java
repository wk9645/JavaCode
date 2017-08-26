

public class PuppleSort {

	public static void main(String[] args) {

		int arr[] = new int[] {1,3,6,9,7,2,8,5,4};
		// 1、冒泡
		// puppleSort(arr);

		// 2、直接插入
		// insertSort(arr);

		// 3、简单选择
		// selectSort(arr);

		// 4、快速排序
//		qSort(arr, 0, arr.length - 1);

		// 5、归并排序
		 mergeSort(arr);
		 
//		 System.out.print("排序后为：");
//		 print(arr);
	
	}

	/*
	 * 5、归并排序
	 */

	public static void mergeSort(int arr[]) {
		sort(arr, 0, arr.length - 1);
	}

	// 调用merge方法，实现二路合并
	public static void sort(int arr[], int left, int right) {

		if (left < right) {

			// 找出中间索引
			int center = (left + right) >> 1;
			// /对左边数组进行排序
			sort(arr, left, center);
			// 对右边数组进行排序
			sort(arr, center + 1, right);
			// 合并数组
			merge(arr, left, center, right);
			// 打印
			print(arr);
		}

	}

	/**
	 * 
	 * @param arr
	 *            给定数组
	 * @param lFirst
	 *            左数组的第一个元素索引
	 * @param lLast
	 *            左数组的最后一个元素索引
	 * @param rLast
	 *            右数组的最后一个元素的索引
	 */
	public static void merge(int arr[], int lFirst, int lLast, int rLast) {

		// 创建一个临时数组
		int tempArr[] = new int[arr.length];
		// 右数组的第一个元素索引
		int rFirst = lLast + 1;
		// 临时数组的索引
		int tempIndex = lFirst;
		// 记录左数组的第一个索引值
		int lFirstPre = lFirst;

		// 对两数组的元素依次进行比较
		while (lFirst <= lLast && rFirst <= rLast) {

			if (arr[lFirst] <= arr[rFirst]) {
				tempArr[tempIndex++] = arr[lFirst++];
			} else
				tempArr[tempIndex++] = arr[rFirst++];
		}

		// 然后将其中的一个数组的剩余元素复制到临时数组中
		// 如果是左数组
		while (lFirst <= lLast) {
			tempArr[tempIndex++] = arr[lFirst++];
		}
		// 如果右数组
		while (rFirst <= rLast) {
			tempArr[tempIndex++] = arr[rFirst++];
		}

		// 然后将临时数组中的所有元素都复制到原来的数组中
		while (lFirstPre <= rLast) {
			arr[lFirstPre] = tempArr[lFirstPre++];
		}

	}

	// 打印数组元素
	public static void print(int arr[]) {
		for (int item : arr) {
			System.out.print(item);
		}
		System.out.println();

	}

	/*
	 * 4、快速排序 选择一个基数，定义两个指针分别指向头部和尾部head和end，head指向的元素和 基数进行比较，如果大于则交换，否则指针右移
	 */
	public static int quickSort(int arr[], int front, int back) {

		int base = arr[back];
		while (front < back) {

			for (; front < back; front++) {

				if (arr[front] > base) {
					arr[back] = arr[front];
					break;
				}

			}

			for (; front < back; back--) {

				if (arr[back] < base) {
					arr[front] = arr[back];
					break;
				}
			}
		}
		arr[back] = base;
		return back;

	}

	public static void qSort(int arr[], int front, int back) {

		if (front < back) {

			int index = quickSort(arr, front, back);
			qSort(arr, front, index - 1);
			qSort(arr, index + 1, back);

		}
	}

	/*
	 * 3、简单选择排序 每次从数组中选出最小的值放在最前面
	 */
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

	// 2、直接插入排序:前面0~i为排好序，后面i~arr.length未排序
	// 先从未排好序部分的第一个元素与前面元素依次比较
	// 直到遇到第一个不大于该元素为止，否则所有元素依次后移，然后将这个元素
	// 放在此处
	public static void insertSort(int arr[]) {

		int target = 0;
		int j = 0;

		for (int i = 1; i < arr.length; i++) {
			target = arr[i];
			/*
			 * for(j=i;j>0;--j){
			 * 
			 * //如果大于target，则元素后移，否则停止比较 if(arr[j-1] > target){
			 * 
			 * arr[j] = arr[j-1]; } else break;
			 * 
			 * } arr[j] = target;
			 */
			j = i;
			while (j > 0 && target < arr[j - 1]) {

				arr[j] = arr[j - 1];
				j--;
			}

			arr[j] = target;
		}
	}

	// 1、冒泡排序
	public static void puppleSort(int arr[]) {

		for (int i = 0; i < arr.length - 1; ++i) {

			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}

}
