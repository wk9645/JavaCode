package com.wk.array;

import java.util.Scanner;

/*
 * 问题：向一个有序数组中插入一个数，保证数组仍有序
 * 
 * 
 * 思路：创建一个比原数组长度多一的数组，然后遍历数组返回新插入的数应在
 * 		合适位置的index，然后将index后面的元素依次后移，再将该数插入
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
