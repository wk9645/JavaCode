package com.wk.array;

import java.util.Scanner;

/*
 * ���⣺��һ�����������в���һ��������֤����������
 * 
 * 
 * ˼·������һ����ԭ���鳤�ȶ�һ�����飬Ȼ��������鷵���²������Ӧ��
 * 		����λ�õ�index��Ȼ��index�����Ԫ�����κ��ƣ��ٽ���������
 * 
 */
public class Insert {
	

	public static void main(String[] args) {
	int index = -1;
	Scanner input = new Scanner(System.in);
	int newNum = input.nextInt();
	int a[] = new int[4];
	a[0]=98;
	a[1]=89;
	a[2]=56;
	
	for(int i=0;i<a.length;++i){
		if(newNum > a[i]){
			index = i;
			break;
		}
	}	
	for(int j=a.length-1;j>index;--j){
		a[j] = a[j-1];
	}
	a[index]=newNum;
	
	for(int num:a){
		System.out.print(num+" ");
	}
		
	
	}
}
