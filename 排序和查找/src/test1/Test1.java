package test1;

/*
 * ��������
 * 
 */
public class Test1 {
	

	/*
	 * (1)ֱ�Ӳ�������
	 * 
	 * �㷨�������Ϊ�������֣�ǰ�沿��0~i-1Ϊ���ź��򣬴Ӻ��沿��i~n�ĵ�һ��Ԫ��
	 * 		��ʼ������Ԫ�ر���Ϊtarget��ǰ�沿�ִ����������αȽϣ�ֱ��������һ��
	 * 		������target��Ԫ�ػ��Ѵ���������ʼλ��Ϊֹ�����򽫺����Ԫ�����κ���
	 * 		���target���Ƶ�ֹͣʱ��Ӧ����������Ȼ���Դ����ƣ�ֱ������Ԫ�ض���
	 * 		����Ϊֹ
	 * 
	 */
	public void dInsert(int arr[]){
		int j;
		int target;
		//�ٶ���һ��Ԫ��Ϊ�ź��򲿷�
		for(int i=1;i<arr.length;i++){
			target=arr[i];
			for(j=i;j>0;j--){
				if(arr[j-1]>target){
					arr[j]=arr[j-1];
				}
				else
					break;
			}
			/*j=i;
			while(j>0&&target<arr[j-1]){
				arr[j]=arr[j-1];
				j--;
			}*/
			arr[j]=target;
		}
	}
	
	
	/*
	 * 2��ϣ������
	 * 
	 * �㷨˼�룺���õ��Ƿ��η�����С������������һ��������������Ϊ����
	 * 		       �����зֳ����ɸ����У�Ȼ���ÿ�����н���һ��ֱ�Ӳ�������
	 * 		       Ȼ����С�������ظ��������裬ֱ���������Ϊ1����
	 * 		       ���������н���һ������
	 * 
	 */
	
	public static void shellSort(int arr[]){
		
		if(arr == null || arr.length<=0)
			return;
		
		int h = 1;
		int j = 0;
		while(h < arr.length / 3){
			h = h*3+1;
		}
		
		while(h > 0){
			
			for(int i=h; i<arr.length; i+=h){
				
				int temp = arr[i];
				for(j = i-h; j>=0; j-=h){
					if(temp > arr[j])
						break;
					arr[j+h] = arr[j];
				}
				arr[j+h] = temp;
			}
			h = (h-1)/3;
			
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Test1 t =new Test1();
		int arr[] = new int[]{5,1,8,3,7,4};
//		t.dInsert(arr);
		
		shellSort(arr);
		for(int num : arr){
			System.out.print(num);
		}
	}
}
