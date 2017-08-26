package com.wk.order;

import java.util.Arrays;
import java.util.Scanner;

public class MyOrder {
	public static void main(String[] args) {
				
		
		Scanner scan = new Scanner(System.in);
		
		//�˵�
		String[] menu = new String[]{"������˿","�Ǵ��Ｙ","��������",
									"��������","ˮ����Ƭ","��ĩ����"};
		//�۸�
		int[] price = new int[]{38,32,22,22,39,25};
		//����
		int[] support = new int[]{25,35,18,26,32,28};
		//���
		String[] select = null;
		int dishPrice = 0;
		do{
			System.out.println("************�Ի����˶���ϵͳ*************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("0���˳�ϵͳ");
			System.out.println("*************************************");
			System.out.println("��ѡ�����");
			int num = scan.nextInt();
			switch (num) {
			case 1:
				//1����Ҫ����
				System.out.println("����ݲ˵����");
				System.out.println("����"+"\t\t����"+"\t��");
				for(int i=0;i<menu.length;i++){
					System.out.println("["+menu[i]+"]\t"+price[i]+"Ԫ\t"+support[i]);
				}
				System.out.println("���������(��ѡ�ԶٺŸ���)��");
				String dish = scan.next();
				String regex = "��";
				String[] dishes = dish.split(regex);
				
				select = Arrays.copyOf(dishes,dishes.length);
				System.out.println("��˳ɹ������Եȣ�");
				break;
			case 2:
				//2���鿴�ʹ�
				System.out.println("����Ĳ��У�");
				for(String dishName : select){
					System.out.println(dishName);
				}
				break;
			case 3:
				//3��ǩ�ն���
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
					System.out.println("��~~����û�е�ͣ�");
				System.out.println("���Ķ����۸�Ϊ��"+dishPrice+"Ԫ����ǩ�գ�");
				dishPrice = 0;
				
				break;
				
			case 4:
				//4��ɾ������
				System.out.println("��ȷ��Ҫɾ��������(Y/N)");
				String input2 = scan.next();
				if("Y".equals(input2)){
					System.out.println("ȡ��������ԭ��");
					System.out.println("1������̬�Ȳ��ã�");
					System.out.println("2���۸�̫��");
					System.out.println("3���˵�����̫�٣�");
					System.out.println("4������");
					System.out.println("��������ţ�");
					String input3 = scan.next();
					System.out.println("��л���ķ��������ǻ�������ƣ�");
				}
				break;
				
			case 5:
				//5����Ҫ����
				System.out.println("������о����������ްɣ�(��������Ӧ����)");
				String input4 = scan.next();
				String[] select2 = input4.split(","); 
				for(String dishName2 : select2){
					for(int i=0;i<menu.length;i++){
						if(dishName2.contains(menu[i]))
							support[i]+=1;
					}
				}
				System.out.println("����֧�־����������Ķ�����");
				break;
				
			case 0:
				//0���˳�ϵͳ
				System.out.println("ȷ��Ҫ�˳���(Y/N)");
				String input = scan.next();
				if("Y".equals(input)){
					System.out.println("��ӭ���´�ʹ�ã�");
					System.exit(0);
				}
				break;
				
			default:
				break;
			}
			
		}while(true);
	}
}
