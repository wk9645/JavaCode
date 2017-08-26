package com.example.wk.select;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * 使用LinkedList来进行存储
 */

public class Select {
	
	public static void menu(){
		System.out.println("a:添加一名运动员");
		System.out.println("s：改变排名");
		System.out.println("d:删除一名运动员");
		System.out.println("q:退出");
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		LinkedList<String> list = new LinkedList<String>();
		int fromIndex ,toIndex;
		String playName ,name;
		char ch;
		String plays[]={"翁凯","张佳彬","张博","王维文","吴宇哲","朱云鹏"};
		for(int i=0;i<plays.length;i++){
			list.add(plays[i]);
		}
		System.out.println("当前排名为:"+list);
		menu();
		System.out.println("请选择更新行为:");
		while(true){		
			Scanner input = new Scanner(System.in);
			ch = input.next().charAt(0);
			switch(ch){
			case 'a':
				playName= input.next();
				list.add(playName);
				break;
			case 'd':
				playName= input.next();
				list.remove(playName);
				break;
			case 's':
				fromIndex= input.nextInt();
				fromIndex--;
				toIndex= input.nextInt();
				toIndex--;
				name= list.remove(fromIndex);
				list.add(toIndex, name);
				break;
			case 'q':
				System.exit(0);
			default:
				System.out.println("您输入有误！");
				break;
			}		
			System.out.println("当前排名为:"+list);
			System.out.println("请继续输入:");
		}	
	}
}
