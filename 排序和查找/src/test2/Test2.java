package test2;

/*
 * ѡ������
 * 
 * (1)��ѡ������
 * 
 * �㷨����������ѡ����С�������һ��λ�õ�����������������̶������򲿷֣�
 * 		Ȼ����ʣ�µ����򲿷����ҳ���С���������һ�����������������ƣ�ֱ��
 * 		���е������ź���
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
