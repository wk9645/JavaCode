package chapter08;
import java.util.Scanner;
public class AccountCardTest {
public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	AccountCard.setInterest(0.03);//������
	System.out.println("�����ʣ�"+AccountCard.getInterest());
	String account;
	String name;
	String id;
	String address;
	double balance;
	Scanner input=new Scanner(System.in);
	System.out.println("�������˺ţ�");
	account=input.next();
	System.out.println("������������");
	name=input.next();
	System.out.println("���������֤�ţ�");
	id=input.next();
	System.out.println("�������ַ��");
	address=input.next();
	System.out.println("�������");
	balance=input.nextDouble();
	AccountCard wang=new AccountCard(account,name,id,address,balance);
	//ͨ�����췽����ʼ���ֿ�����Ϣ
	//AccountCard wang=new AccountCard�����޲δ�����Ķ���
	int choice;
	double cash;
	do{wang.menu();//�������֣�ѡ��˵�
	Scanner input2=new Scanner(System.in);
	choice=input2.nextInt();
	switch(choice){
	case 1://���
		cash=input2.nextDouble();
		wang.deposit(cash);
	break;
	case 2://ȡ��
		cash=input2.nextDouble();
		wang.withdraw(cash);
	break;
	case 3://����
		cash=input2.nextDouble();
		wang.withdraw(cash);
	break;
	case 4://��ѯ
		cash=input2.nextDouble();
		wang.query();
	break;
	case 5://����
		System.out.println("лл����ʹ��");
		System.exit(1);
	}}
	while(choice!=5);  
	}}
