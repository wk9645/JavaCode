package chapter08;
import java.util.Scanner;
public class AccountCardTest {
public static void main(String[] args) {
		// TODO 自动生成的方法存根
	AccountCard.setInterest(0.03);//年利率
	System.out.println("年利率："+AccountCard.getInterest());
	String account;
	String name;
	String id;
	String address;
	double balance;
	Scanner input=new Scanner(System.in);
	System.out.println("请输入账号：");
	account=input.next();
	System.out.println("请输入姓名：");
	name=input.next();
	System.out.println("请输入身份证号：");
	id=input.next();
	System.out.println("请输入地址：");
	address=input.next();
	System.out.println("请输入金额：");
	balance=input.nextDouble();
	AccountCard wang=new AccountCard(account,name,id,address,balance);
	//通过构造方法初始化持卡人信息
	//AccountCard wang=new AccountCard（）无参创建类的对象
	int choice;
	double cash;
	do{wang.menu();//输入数字，选择菜单
	Scanner input2=new Scanner(System.in);
	choice=input2.nextInt();
	switch(choice){
	case 1://存款
		cash=input2.nextDouble();
		wang.deposit(cash);
	break;
	case 2://取款
		cash=input2.nextDouble();
		wang.withdraw(cash);
	break;
	case 3://购物
		cash=input2.nextDouble();
		wang.withdraw(cash);
	break;
	case 4://查询
		cash=input2.nextDouble();
		wang.query();
	break;
	case 5://购物
		System.out.println("谢谢您的使用");
		System.exit(1);
	}}
	while(choice!=5);  
	}}
