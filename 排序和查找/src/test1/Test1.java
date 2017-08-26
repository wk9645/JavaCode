package test1;

/*
 * 插入排序
 * 
 */
public class Test1 {
	

	/*
	 * (1)直接插入排序
	 * 
	 * 算法：数组分为两个部分，前面部分0~i-1为已排好序，从后面部分i~n的第一个元素
	 * 		开始，将该元素备份为target与前面部分从右向左依次比较，直到遇到第一个
	 * 		不大于target的元素或已处于数组起始位置为止，否则将后面的元素依次后移
	 * 		最后将target复制到停止时对应的索引处。然后以此类推，直至所有元素都排
	 * 		好序为止
	 * 
	 */
	public void dInsert(int arr[]){
		int j;
		int target;
		//假定第一个元素为排好序部分
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
	 * 2、希尔排序
	 * 
	 * 算法思想：采用的是分治法，缩小增量排序，设置一个增量，以增量为步数
	 * 		       将序列分成若干个序列，然后对每个序列进行一次直接插入排序，
	 * 		       然后缩小增量，重复上述步骤，直到最后增量为1，即
	 * 		       对整个序列进行一次排序
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
