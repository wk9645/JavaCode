package com.wk.suanfa;

/*
 * ��Ŀ����һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С����
 * 		�����������º�ÿ��������һ�����ӣ��������Ӷ���������ÿ����
 * 		�����������Ƕ��٣�
 * 
 * ����������һ��쳲������������⣬Ӧʹ�õݹ���
 * 
 */
public class test1 {

	static int num = 0;
	public static void main(String[] args) {

		NumOfRubbit(5);
		
	}
	
	public static int NumOfRubbit(int n){
		if(n > 2 ){
			num = NumOfRubbit(n-1)+NumOfRubbit(n-2);
			System.out.println("��"+n+"������"+num+"������");
			return num;
		}else if(n == 1)
			System.out.println("��1������2������");
		else if(n == 2)
			System.out.println("��2������2������");
		return 2;
	}
	
}
