package com.wk.array;


/**
 * ð������ԭ�����αȽ����ڵ���������
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


public class PubbleSort {
	
	
	
	public static void main(String[] args) {
		int x;
		int arr[] = new int[]{2,8,5,9,3};
		for(int i=0;i<arr.length-1;++i){
			for(int j=0;j<arr.length-i-1;++j){
				if(arr[j]<arr[j+1]){
					x=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=x;
				}
			}
		}
		for(int num : arr){
			System.out.print(num+" ");
		}
	}
}
