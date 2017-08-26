

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
	 * �۰�����
	 * 		ԭ��:��������ֱ�Ӳ�������,�ڽ��в������ʱ,���������������н��ж��ֲ���,
	 * 			�ҵ��ɲ�����������ٽ���Ԫ�غ���,Ȼ�����Ԫ��
	 * 	
	 */
	public static void binarySort(int arr[]){
		
		for(int i=1;i<arr.length;++i){
			
			//���浱ǰ��i��ֵ
			int temp = arr[i];
			
			//��������ָ��ָ�����ź��򲿷ֵ�ͷβ
			int head = 0;
			int end = i-1;
			
		//���ֲ���,�ҳ�������temp������
		while(head <= end){
			//ÿһ��ѭ����һ���м�ֵ
			int center = (head + end) >> 1;
			if(arr[center] < temp)
				head = center + 1;
			else
				end = center - 1;
		}
		//��ʱhead==end,Ȼ�����
		int j;
		for(j=i-1; j>end; j--){
			arr[j+1] = arr[j];
		}
		//��ֵ
		arr[j+1] = temp;
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * ϣ������:
	 * 		ԭ��:������������һ���ɱ������Ϊ������Ϊ���ɸ�������,Ȼ���
	 * 			�������������ֱ�Ӳ�������,��Ϊһ��ѭ��,Ȼ����С����,��
	 * 			����������,�ظ���������,ֱ����������Ϊ1,������������
	 * 			����һ�β�������.
	 * 		ʱ�临�Ӷ�:����ΪO(n^2),ƽ��ΪO(nlogn).
	 * 
	 */

	public static void shellSort(int arr[]) {

		if (arr == null || arr.length <= 0) {
			return;
		}

		int h = 1;
		// ������������ֵ
		while (h <= arr.length / 3) {
			h = h * 3 + 1;
		}

		while (h > 0) {

			// ��hΪ�����������������,��ÿ��ĵ�һ��Ԫ����Ϊ���ź���,
			// ��δ�ź���ĵ�һ��Ԫ�ؿ�ʼ��ǰ�����αȽ�

			// ��һ��ѭ�����ڷ���
			for (int i = h; i < arr.length; i += h) {
				// ����δ���򲿷ֵ�һ��Ԫ��ֵ
				int temp = arr[i];
				while (i > 0 && temp < arr[i - h]) {
					// ����
					arr[i] = arr[i - h];
					i -= h;
				}
				// ��temp�ŵ��հ״�
				arr[i] = temp;
			}

			// �����µ�����
			h = (h - 1) / 3;

		}
	}

}
