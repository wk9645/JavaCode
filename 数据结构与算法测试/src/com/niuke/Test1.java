package com.niuke;

/**
 * ����һ���������ң��������·ֱ�������������
 * �ж�һ�����Ƿ�������������
 * 
 * ˼�룺�����½ǻ����Ͻǵ�ֵ���бȽϣ�
 * 		����������Ͻǵ�ֵ��Ŀ��ֵֻ
 * 		�������棬��row++�����С��
 * 		��ֻ������ߣ���col--
 * @author wk
 *
 */
public class Test1 {

	public boolean isExist(int args[][],int targer){
			
		int row = 0;
		int col = args[0].length - 1;
		while(row <= args.length - 1 && col >= 0){
			if(targer == args[row][col]){
				return true;
			}
			else if(targer > args[row][col]){
				row++;
			}
			else{
				col--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int array[][]=new int[][]{{1,2,3,4},
								  {12,13,14,15},
								  {23,24,25,26},
							      {34,35,36,37}};

		Test1 test = new Test1();
		boolean result = test.isExist(array,13);
		System.out.println(result);
		
	}
}
