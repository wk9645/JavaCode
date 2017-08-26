package chapter08;
import java.util.Date;
	public class AccountCard {//自定义AccountCard类
		/*年利率，账号，持卡人姓名，身份证号码，地址；交易金额，交易日期，余额*/
	public static double interest;//私有，静态 
	private String account;//私有
	private String name;
	private String id;
	private String address;
	private double DWAmount;
	private Date DWDate;
	private double balance;
	/*无参构造方法*/
	public AccountCard(){//初始化持卡人信息
		super();
		this.account="1111111110";
		this.name="王朝";		
		this.id="3210020199809181215";
		this.address="持卡人地址";
		this.balance=0;
	}
	/*带参构造方法*/
	public AccountCard(String account,String name,String id,String address,double balance){
		super();
		this.account=account;
		this.name=name;		
		this.id=id;
		this.address=address;
		this.balance=balance;
	}
	public void menu(){//菜单方法
		System.out.println("\n欢迎使用银行ATM系统");
		System.out.println("\t1.存款");
		System.out.println("\t2.取款");
		System.out.println("\t3.购物取款");
		System.out.println("\t4.查询");
		System.out.println("\t5.退出");
		System.out.println("请选择输入数字【1-5】:");
	}
	public static double getInterest(){
		//静态getter()
		return interest;
	}
	public static void setInterest(double interest){
		//静态setter
		AccountCard.interest=interest;
	}
	public String getAccount(){//getter()
		return account;
	}
	public void setAccount(String account){//setter()
		this.account=account;
	}
	public String getname(){
		return name;
	}
	public String getName(){
		return name;
	}
	public String getId(){	
		return id;
	}
	public void setId(String id){
		this.id=id;	
	}
	public String getAddress(){
		return address;
	}	
	public void setAddress(String address){
		this.address=address;	
	}
	public void setbalance(Double balance){
		this.balance=balance;	
	}
	public void deposit(double cash){
		System.out.println("=========存款=========");
		System.out.println("您的卡号："+this.account);//代表当前类的实例
		System.out.println("您的姓名："+this.name);
		System.out.println("原有余额："+this.balance);
		System.out.println("现存入："+cash);
		this.DWAmount=cash;
		balance=this.balance+cash;
		System.out.println("最终余额："+this.balance);
		this.DWDate=new Date();//记录当天的日期
		System.out.println("存款日期："+this.DWDate);
	}
	public void withdraw(double cash){//类的取款行为(方法)
		System.out.println("=========取款=========");
		System.out.println("您的卡号："+this.account);//代表当前类的实例
		System.out.println("您的姓名："+this.name);
		System.out.println("原有余额："+this.balance);
		System.out.println("现取出："+cash);
		this.DWAmount=cash;
		if(this.balance-cash>0){//禁止透支
		this.balance=this.balance-cash;//余额自动计算
		System.out.println("最终余额："+this.balance);}
		else{
			System.out.println("重新输入！");
		}
		this.DWDate=new Date();
		System.out.println("取款日期："+this.DWDate);	
		}	
		public void query(){//类的查询行为
			System.out.println("=========查询=========");
			System.out.println("您的卡号："+this.account);//代表当前类的实例
			System.out.println("您的姓名："+this.name);
			System.out.println("最终余额是："+this.balance);
			this.DWDate=new Date();
			System.out.println("查询日期："+this.DWDate);
		}
		public void purchase(double payment){//类的付款行为	
			System.out.println("=========购物=========");
			System.out.println("您的卡号："+this.account);//代表当前类的实例
			System.out.println("您的姓名："+this.name);
			System.out.println("原有余额："+this.balance);
			System.out.println("现付出："+payment);
			this.DWAmount=payment;
			if(this.balance-payment>0){//禁止透支
			this.balance=this.balance-payment;//余额自动计算
			System.out.println("最终余额："+this.balance);}
			else{
				System.out.println("余额不足！！");
			}
			this.DWDate=new Date();
			System.out.println("付款日期："+this.DWDate);	
		
	}}

