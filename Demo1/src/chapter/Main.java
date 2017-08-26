package chapter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		File file=null;
		boolean isRead=false;
		while(file==null){
		System.out.print("�����������ļ�λ��: ");
		String path=null;
		try{
			path=input.nextLine();
		}catch(Throwable e){
			System.out.println("������δ֪�Ĵ����˳�");
			e.printStackTrace(System.out);
			System.exit(1);
		}
		
		file=new File(path);
		isRead=file.exists();
		if(!DataManager.checkFile(file)){
			System.out.println("�ļ���Ч��������ָ��");
			file=null;
		}
		}
		
		DataManager db=null;
		if(isRead){
			boolean success=false;
			try {
				db=new DataManager(file);
			} catch (Exception e) {
				System.out.println("��ʧ�ܣ�������δ֪�����ݴ���");
				e.printStackTrace();
				System.exit(1);
			}
			for(byte i=0;i<3;i++){
				System.out.print("����������: ");
				if(db.password.equals(input.nextLine())){
					success=true;
					break;
				}else{
					System.out.println("�������");
				}
			}
			if(!success){
			System.out.println("�������̫�࣬�˳� ");
			System.exit(0);
			}
		}else{
		System.out.print("������������: ");
		try {
			db=new DataManager(file,input.nextLine());
		} catch (IOException e) {
			System.out.println("������δ֪�����˳�");
			e.printStackTrace();
			System.exit(1);
		}
		
		}
		System.out.println("=====================================");
		System.out.println("��ʾ:�û����������ļ�");
		System.out.println("ע��:�����ļ�������д��Ȩ�ޣ��༶ѧ���������ó���"+0x7fff+"�ˣ�ѧ�����䲻�ó���"+0x7f+"�꣬����ᷢ��һ��δ֪�Ĵ���");
		System.out.println("=====================================");
		while(true){
			System.out.print("> ");
			String[] param=input.nextLine().split(" ");
			if(param.length<1){
				continue;
			}
			switch(param[0]){
			case "q":
			case "exit":
			case "�˳�":
				System.out.println("=====================================");
				try {
					db.save();
				} catch (Exception e) {
					System.out.println("���ݱ���ʧ��");
					e.printStackTrace();
					System.exit(1);
				}
				input.close();
				System.out.println("ллʹ��");
				System.exit(0);
			break;
			case "1":
				if(param.length<2){
					System.out.println("������ѧ��");
					break;
				}
				int ii;
				try{
				ii=Integer.parseInt(param[1]);
				}catch(Throwable e){
					System.out.println("��������Ч��ѧ��");
					break;
				}
				ii&=0x7fff;
			Account stu1=db.list[ii];
			if(stu1==null){
				System.out.println("���޴��� ");
			}else{
				System.out.println(stu1.toString());
			}
				break;
			case "2":
				int[] sxx=new int[0x80];
				for(Account stu2:db.list){
					if(stu2!=null){
					sxx[stu2.getAge()]++;
					}
				}
				
				for(byte i=0;i>=0;i++){
					if(sxx[i]>0){
						System.out.println("����: "+i+",����: "+sxx[i]);
					}
				}
			break;
			case "3":
				boolean success=false;
				for(byte i=0;i<3;i++){
					
					System.out.print("����������: ");
					String n=input.nextLine();
					for(Account stu:db.list){
						if(stu!=null&&stu.getName().equals(n)){
							db.list[stu.getId()]=null;
							success=true;
						}
					}
					if(success){
						break;
					}
				}
				if(!success){
					System.out.println("����3�Σ��˳�");
					System.exit(0);
				}
			break;
			case "4":
				for(Account stu:db.list){
					if(stu!=null&&stu.getSex()==Sex.X){
						byte age=stu.getAge();
						if(age<18){
							age++;
								age&=0x7f;
							stu.setAge(age);
						}
					}
				}	
			break;
			case "5":
			case "add":
			case "���":
			short id=db.findEmptyId();
			if(id==-1){
				System.out.println("����ѧ��̫��");
				break;
			}
			
			String n=null;
			byte age=-1;
			Sex sex=null;
			try{
			n=param[1];
			age=Byte.parseByte(param[2]);
			sex=Sex.parseSex(param[3]);
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("������ȫ����鿴����");
				break;
			}catch(NumberFormatException e){
				System.out.println("����������鿴����");
				break;
			}
			if(n==null||sex==null||age<0){
				System.out.println("�����쳣����鿴����");
				break;
			}
			Account stu=new Account(id,n,sex,age);
			db.list[id]=stu;
			System.out.println("����ӵ����: "+id);
			break;
			case "ls":
				for(Account stu6:db.list){
					if(stu6!=null){
						System.out.println(stu6.toString());
					}
				}
			break;
			case "gc":
			System.gc();
			break;
			case "h":
			case "help":
			case "����":
				default:
				System.out.println("ʹ��˵�������������б�");
				System.out.println("�˳�");
				System.out.println("1 <int:ѧ��> #���ָ��ѧ�ŵ�ѧ����Ϣ");
				System.out.println("2 #�������ѧ������Ϣ");
				System.out.println("3 #ɾ��ָ�����Ƶ�ѧ��");
				System.out.println("4 #��Ů��û��18������+1");
				System.out.println("5 <string:����> <int:����> <enum(��,Ů):�Ա�> #���ѧ��");
			break;
			}
		}

	}

}