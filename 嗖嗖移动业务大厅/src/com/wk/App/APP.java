package com.wk.App;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

import javax.swing.plaf.TreeUI;

import com.wk.entity.ConsumeInfo;
import com.wk.entity.MobileCard;
import com.wk.entity.NetPackage;
import com.wk.entity.ServicePackage;
import com.wk.entity.SuperPackage;
import com.wk.entity.TalkPackage;
import com.wk.service.IOptionsService;
import com.wk.service.impl.OptionsService;
import com.wk.utils.CardUtil;
import com.wk.utils.DaoUtil;

public class APP {

	private static IOptionsService	service = new OptionsService();
//	private static MobileCard mCard;
	
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		while(true){
			
			menu1();
			System.out.println("请输入要选择的功能：");
			
			int num = input.nextInt(); 
			switch (num) {
			case 1:
				//1、用户登录
				System.out.println("请输入手机卡号：");
				String mobileNumber = input.next();
				System.out.println("请输入密码：");
				String pwd = input.next();
				
				MobileCard mCardLogin = new MobileCard();
				mCardLogin.setCardNumber(mobileNumber);
				mCardLogin.setPassword(pwd);
				//返回登录用户
				MobileCard mobileCard = service.login(mCardLogin);
				
				if(mobileCard == null)
					System.out.println("登录失败！");
				else{
					System.out.println("欢迎" + mobileCard.getUserName() + "先生！");
					//进入登录
					while(mobileCard != null){
						
						menu2();
						System.out.println("请选择功能(1~5)：");
						int num2 = input.nextInt();
						switch (num2) {
						case 1:
							//1、本月账单查询
							double charge = service.consumeQueryCurrMon(mobileCard);
							ServicePackage sp = mobileCard.getSerPackage();
							double money = (sp instanceof TalkPackage) ? 58 : (sp instanceof NetPackage) ? 68 : 78;
							DecimalFormat df = new DecimalFormat("#.0");
							String chargeStr = df.format(money);
							String totalStr = df.format(money + charge);
							
							System.out.println("您的卡号：" + mobileCard.getCardNumber() + ",当月账单：");
							System.out.println("套餐资费：" + chargeStr + "元");
							System.out.println("合计：" + totalStr + "元");
							
							
							break;
						case 2:
							//2、套餐余量查询
							service.remainingPackage(mobileCard);
							break;
						case 3:
							//3、打印消费详单
							service.printConsumeInfo(mobileCard);
							break;
						case 4:
							//4、套餐变更
							break;
						case 5:
							//5、办理退网
							boolean logout = service.logout(mobileCard);
							if(logout)
								System.out.println("办理退网成功！");
							break;
						case 6:
							//注销
							System.out.println("用户已注销！");
							break;
						}
						
					}
				}
				break;
			case 2:
				//2、用户注册
				System.out.println("可用的手机号有：");
				String[] numbers = CardUtil.getNewNumbers(5);
				for(String number : numbers){
					System.out.println(number);
				}
				System.out.println("请选择一个：");
				String selectNum = input.next();
				System.out.println("1、话唠套餐   2、网虫套餐   3、超人套餐");
				System.out.println("请选择(输入序号)：");
				int selectPack = input.nextInt();
				
				MobileCard mCardRegis = new MobileCard();
				mCardRegis.setCardNumber(selectNum);
				ServicePackage sp = selectPack == 1 ? new TalkPackage() : selectPack == 2 ? new NetPackage() : new SuperPackage();
				//保存固定资费
				int charge = selectPack == 1 ? 58 : selectPack == 2 ? 68 : 78;
				
				mCardRegis.setSerPackage(sp);
				
				System.out.println("请输入姓名：");
				String userName = input.next();
				mCardRegis.setUserName(userName);
				
				System.out.println("请输入密码：");
				String password = input.next();
				mCardRegis.setPassword(password);
				
				
				int money = 0;
				while(true){
					boolean flag = true;
					if(flag){
						System.out.println("请输入预存话费金额：");
					}
					flag = false;
					money = input.nextInt();
					if(money < charge){
						
						System.out.println("您预存的话费金额不足以支付本月固定套餐资费，请重新充值：");
						
					}else {
						break;
					}
				}
				
				if(service.register(mCardRegis)){
					
					System.out.println("注册成功！" + "卡号：" + selectNum + "，用户名：" + userName +  "，当前余额：" + (money - charge) + "元");
					if(sp instanceof TalkPackage){
						TalkPackage tk = (TalkPackage) sp;
						tk.showInfo();
					}
					if(sp instanceof NetPackage){
						NetPackage np = (NetPackage) sp;
						np.showInfo();
					}
					if(sp instanceof SuperPackage){
						SuperPackage sPackage = (SuperPackage) sp;
						sPackage.showInfo();
					}
				}
				
				break;
			case 3:
				//3、使用嗖嗖
				break;
			case 4:
				//4、话费充值
				break;
			case 5:
				//5、资费说明
				break;
			case 6:
				//6、退出系统
				System.out.println("感谢使用！");
				System.exit(0);
				break;

			}
			
			
		}
		
	}
	
	
	/*
	 * 主菜单
	 */
	
	public static void menu1(){
		
		System.out.println("*****欢迎使用嗖嗖移动业务大厅*****");
		System.out.println("*********1、用户登录***********");
		System.out.println("*********2、用户注册***********");
		System.out.println("*********3、使用嗖嗖***********");
		System.out.println("*********4、话费充值***********");
		System.out.println("*********5、资费说明***********");
		System.out.println("*********6、退出系统***********");
		
	}

	
	/*
	 * 子菜单
	 */
	public static void menu2(){
		
		System.out.println("*******嗖嗖移动用户菜单***********");
		System.out.println("*******1、本月账单查询************");
		System.out.println("*******2、套餐余量查询************");
		System.out.println("*******3、打印消费详单************");
		System.out.println("*******4、套餐变更************");
		System.out.println("*******5、办理退网************");
		System.out.println("请选择(1-5)，其他键返回上一级：");
	}
	
}
