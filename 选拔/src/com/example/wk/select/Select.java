package com.example.wk.select;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * ʹ��LinkedList�����д洢
 */

public class Select {
	
	public static void menu(){
		System.out.println("a:���һ���˶�Ա");
		System.out.println("s���ı�����");
		System.out.println("d:ɾ��һ���˶�Ա");
		System.out.println("q:�˳�");
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		LinkedList<String> list = new LinkedList<String>();
		int fromIndex ,toIndex;
		String playName ,name;
		char ch;
		String plays[]={"�̿�","�żѱ�","�Ų�","��ά��","������","������"};
		for(int i=0;i<plays.length;i++){
			list.add(plays[i]);
		}
		System.out.println("��ǰ����Ϊ:"+list);
		menu();
		System.out.println("��ѡ�������Ϊ:");
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
				System.out.println("����������");
				break;
			}		
			System.out.println("��ǰ����Ϊ:"+list);
			System.out.println("���������:");
		}	
	}
}
