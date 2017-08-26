package com.wk.suanfa;

/*
 * 题目：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子
 * 		长到第三个月后每个月有生一对兔子，假如兔子都不死，问每个月
 * 		的兔子总数是多少？
 * 
 * 分析：这是一个斐波那契数列问题，应使用递归解决
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
			System.out.println("第"+n+"个月有"+num+"对兔子");
			return num;
		}else if(n == 1)
			System.out.println("第1个月有2对兔子");
		else if(n == 2)
			System.out.println("第2个月有2对兔子");
		return 2;
	}
	
}
