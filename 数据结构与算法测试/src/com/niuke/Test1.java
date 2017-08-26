package com.niuke;

/**
 * 给定一个从左向右，从上向下分别自增长的数组
 * 判断一个数是否在这里数组中
 * 
 * 思想：和左下角或右上角的值进行比较，
 * 		如果大于右上角的值则目标值只
 * 		能在下面，即row++，如果小于
 * 		则只能在左边，即col--
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
