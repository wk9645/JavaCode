package test3;

/*
 * 
 * 3�����Q����
 * 
 */


public class Test3 {
	
	
	
	/**
	 * 
	 * ð������
	 * 
	 * ԭ�����αȽ����ڵ���������
	 * ��С����ǰ�棬ֱ�����������������
	 * Ȼ���ظ��������������Ϊ����
	 * 
	 * ��һ��ѭ��Ϊ�ظ��Ĵ�����ѭ������Ϊarray.length-1
	 * �ڶ���ѭ��Ϊ���αȽ����ڵ�����ѭ������Ϊarray.length-1-i
	 * 
	 * ���Ƚ�n*(n-1)/2�Σ�����O(n)=n*n
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
	 * ��������: ��������ѡ��һ����׼Ԫ�أ���������ָ��head��end�ֱ�ָ��
	 * 			���е�ͷ��β
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