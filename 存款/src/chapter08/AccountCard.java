package chapter08;
import java.util.Date;
	public class AccountCard {//�Զ���AccountCard��
		/*�����ʣ��˺ţ��ֿ������������֤���룬��ַ�����׽��������ڣ����*/
	public static double interest;//˽�У���̬ 
	private String account;//˽��
	private String name;
	private String id;
	private String address;
	private double DWAmount;
	private Date DWDate;
	private double balance;
	/*�޲ι��췽��*/
	public AccountCard(){//��ʼ���ֿ�����Ϣ
		super();
		this.account="1111111110";
		this.name="����";		
		this.id="3210020199809181215";
		this.address="�ֿ��˵�ַ";
		this.balance=0;
	}
	/*���ι��췽��*/
	public AccountCard(String account,String name,String id,String address,double balance){
		super();
		this.account=account;
		this.name=name;		
		this.id=id;
		this.address=address;
		this.balance=balance;
	}
	public void menu(){//�˵�����
		System.out.println("\n��ӭʹ������ATMϵͳ");
		System.out.println("\t1.���");
		System.out.println("\t2.ȡ��");
		System.out.println("\t3.����ȡ��");
		System.out.println("\t4.��ѯ");
		System.out.println("\t5.�˳�");
		System.out.println("��ѡ���������֡�1-5��:");
	}
	public static double getInterest(){
		//��̬getter()
		return interest;
	}
	public static void setInterest(double interest){
		//��̬setter
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
		System.out.println("=========���=========");
		System.out.println("���Ŀ��ţ�"+this.account);//����ǰ���ʵ��
		System.out.println("����������"+this.name);
		System.out.println("ԭ����"+this.balance);
		System.out.println("�ִ��룺"+cash);
		this.DWAmount=cash;
		balance=this.balance+cash;
		System.out.println("������"+this.balance);
		this.DWDate=new Date();//��¼���������
		System.out.println("������ڣ�"+this.DWDate);
	}
	public void withdraw(double cash){//���ȡ����Ϊ(����)
		System.out.println("=========ȡ��=========");
		System.out.println("���Ŀ��ţ�"+this.account);//����ǰ���ʵ��
		System.out.println("����������"+this.name);
		System.out.println("ԭ����"+this.balance);
		System.out.println("��ȡ����"+cash);
		this.DWAmount=cash;
		if(this.balance-cash>0){//��ֹ͸֧
		this.balance=this.balance-cash;//����Զ�����
		System.out.println("������"+this.balance);}
		else{
			System.out.println("�������룡");
		}
		this.DWDate=new Date();
		System.out.println("ȡ�����ڣ�"+this.DWDate);	
		}	
		public void query(){//��Ĳ�ѯ��Ϊ
			System.out.println("=========��ѯ=========");
			System.out.println("���Ŀ��ţ�"+this.account);//����ǰ���ʵ��
			System.out.println("����������"+this.name);
			System.out.println("��������ǣ�"+this.balance);
			this.DWDate=new Date();
			System.out.println("��ѯ���ڣ�"+this.DWDate);
		}
		public void purchase(double payment){//��ĸ�����Ϊ	
			System.out.println("=========����=========");
			System.out.println("���Ŀ��ţ�"+this.account);//����ǰ���ʵ��
			System.out.println("����������"+this.name);
			System.out.println("ԭ����"+this.balance);
			System.out.println("�ָ�����"+payment);
			this.DWAmount=payment;
			if(this.balance-payment>0){//��ֹ͸֧
			this.balance=this.balance-payment;//����Զ�����
			System.out.println("������"+this.balance);}
			else{
				System.out.println("���㣡��");
			}
			this.DWDate=new Date();
			System.out.println("�������ڣ�"+this.DWDate);	
		
	}}

