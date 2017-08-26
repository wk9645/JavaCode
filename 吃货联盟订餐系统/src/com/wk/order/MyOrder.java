package com.wk.order;

import java.util.Arrays;
import java.util.Scanner;

public class MyOrder {
	public static void main(String[] args) {
				
		
		Scanner scan = new Scanner(System.in);
		
		//菜单
		String[] menu = new String[]{"鱼香肉丝","糖醋里脊","宫保鸡丁",
									"麻辣豆腐","水煮肉片","肉末粉条"};
		//价格
		int[] price = new int[]{38,32,22,22,39,25};
		//点赞
		int[] support = new int[]{25,35,18,26,32,28};
		//点菜
		String[] select = null;
		int dishPrice = 0;
		do{
			System.out.println("************吃货联盟订餐系统*************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("0、退出系统");
			System.out.println("*************************************");
			System.out.println("请选择服务：");
			int num = scan.nextInt();
			switch (num) {
			case 1:
				//1、我要订餐
				System.out.println("请根据菜单点菜");
				System.out.println("菜名"+"\t\t单价"+"\t赞");
				for(int i=0;i<menu.length;i++){
					System.out.println("["+menu[i]+"]\t"+price[i]+"元\t"+support[i]);
				}
				System.out.println("请输入菜名(多选以顿号隔开)：");
				String dish = scan.next();
				String regex = "、";
				String[] dishes = dish.split(regex);
				
				select = Arrays.copyOf(dishes,dishes.length);
				System.out.println("点菜成功，请稍等！");
				break;
			case 2:
				//2、查看餐袋
				System.out.println("您点的菜有：");
				for(String dishName : select){
					System.out.println(dishName);
				}
				break;
			case 3:
				//3、签收订单
				boolean isEmpty = true;
				for(int i=0;i<select.length;i++){
					for(int j=0;j<menu.length;j++){
						if(menu[j].equals(select[i])){
							dishPrice+=price[i];
							isEmpty = false;
						}
					}
					select[i] = null;
				}
				
				if(isEmpty)
					System.out.println("亲~~您还没有点餐！");
				System.out.println("您的订单价格为："+dishPrice+"元，请签收！");
				dishPrice = 0;
				
				break;
				
			case 4:
				//4、删除订单
				System.out.println("您确定要删除订单吗？(Y/N)");
				String input2 = scan.next();
				if("Y".equals(input2)){
					System.out.println("取消订单的原因：");
					System.out.println("1、服务态度不好？");
					System.out.println("2、价格太贵？");
					System.out.println("3、菜的种类太少？");
					System.out.println("4、其他");
					System.out.println("请输入序号：");
					String input3 = scan.next();
					System.out.println("感谢您的反馈，我们会继续完善！");
				}
				break;
				
			case 5:
				//5、我要点赞
				System.out.println("如果您感觉不错，请点个赞吧！(可输入相应菜名)");
				String input4 = scan.next();
				String[] select2 = input4.split(","); 
				for(String dishName2 : select2){
					for(int i=0;i<menu.length;i++){
						if(dishName2.contains(menu[i]))
							support[i]+=1;
					}
				}
				System.out.println("您的支持就是我们最大的动力！");
				break;
				
			case 0:
				//0、退出系统
				System.out.println("确定要退出吗？(Y/N)");
				String input = scan.next();
				if("Y".equals(input)){
					System.out.println("欢迎您下次使用！");
					System.exit(0);
				}
				break;
				
			default:
				break;
			}
			
		}while(true);
	}
}
