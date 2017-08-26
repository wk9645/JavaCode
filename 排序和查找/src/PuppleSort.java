

public class PuppleSort {

	public static void main(String[] args) {

		int arr[] = new int[] {1,3,6,9,7,2,8,5,4};
		// 1��ð��
		// puppleSort(arr);

		// 2��ֱ�Ӳ���
		// insertSort(arr);

		// 3����ѡ��
		// selectSort(arr);

		// 4����������
//		qSort(arr, 0, arr.length - 1);

		// 5���鲢����
		 mergeSort(arr);
		 
//		 System.out.print("�����Ϊ��");
//		 print(arr);
	
	}

	/*
	 * 5���鲢����
	 */

	public static void mergeSort(int arr[]) {
		sort(arr, 0, arr.length - 1);
	}

	// ����merge������ʵ�ֶ�·�ϲ�
	public static void sort(int arr[], int left, int right) {

		if (left < right) {

			// �ҳ��м�����
			int center = (left + right) >> 1;
			// /����������������
			sort(arr, left, center);
			// ���ұ������������
			sort(arr, center + 1, right);
			// �ϲ�����
			merge(arr, left, center, right);
			// ��ӡ
			print(arr);
		}

	}

	/**
	 * 
	 * @param arr
	 *            ��������
	 * @param lFirst
	 *            ������ĵ�һ��Ԫ������
	 * @param lLast
	 *            ����������һ��Ԫ������
	 * @param rLast
	 *            ����������һ��Ԫ�ص�����
	 */
	public static void merge(int arr[], int lFirst, int lLast, int rLast) {

		// ����һ����ʱ����
		int tempArr[] = new int[arr.length];
		// ������ĵ�һ��Ԫ������
		int rFirst = lLast + 1;
		// ��ʱ���������
		int tempIndex = lFirst;
		// ��¼������ĵ�һ������ֵ
		int lFirstPre = lFirst;

		// ���������Ԫ�����ν��бȽ�
		while (lFirst <= lLast && rFirst <= rLast) {

			if (arr[lFirst] <= arr[rFirst]) {
				tempArr[tempIndex++] = arr[lFirst++];
			} else
				tempArr[tempIndex++] = arr[rFirst++];
		}

		// Ȼ�����е�һ�������ʣ��Ԫ�ظ��Ƶ���ʱ������
		// �����������
		while (lFirst <= lLast) {
			tempArr[tempIndex++] = arr[lFirst++];
		}
		// ���������
		while (rFirst <= rLast) {
			tempArr[tempIndex++] = arr[rFirst++];
		}

		// Ȼ����ʱ�����е�����Ԫ�ض����Ƶ�ԭ����������
		while (lFirstPre <= rLast) {
			arr[lFirstPre] = tempArr[lFirstPre++];
		}

	}

	// ��ӡ����Ԫ��
	public static void print(int arr[]) {
		for (int item : arr) {
			System.out.print(item);
		}
		System.out.println();

	}

	/*
	 * 4���������� ѡ��һ����������������ָ��ֱ�ָ��ͷ����β��head��end��headָ���Ԫ�غ� �������бȽϣ���������򽻻�������ָ������
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
	 * 3����ѡ������ ÿ�δ�������ѡ����С��ֵ������ǰ��
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

	// 2��ֱ�Ӳ�������:ǰ��0~iΪ�ź��򣬺���i~arr.lengthδ����
	// �ȴ�δ�ź��򲿷ֵĵ�һ��Ԫ����ǰ��Ԫ�����αȽ�
	// ֱ��������һ�������ڸ�Ԫ��Ϊֹ����������Ԫ�����κ��ƣ�Ȼ�����Ԫ��
	// ���ڴ˴�
	public static void insertSort(int arr[]) {

		int target = 0;
		int j = 0;

		for (int i = 1; i < arr.length; i++) {
			target = arr[i];
			/*
			 * for(j=i;j>0;--j){
			 * 
			 * //�������target����Ԫ�غ��ƣ�����ֹͣ�Ƚ� if(arr[j-1] > target){
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

	// 1��ð������
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
