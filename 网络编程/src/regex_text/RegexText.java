package regex_text;

import java.util.Scanner;

/*
 * ������ʽ
 * 
 * ����У��qq��
 * 		5~15λ��������0��ͷ��ֻ�������֡�
 */

public class RegexText {

	//1����ͨ�жϷ��� (String��)
	public static void checkQQ_1(String str){
		int len = str.length();
		if(len>=5 && len<=15){
			if(!str.startsWith("0")){
				char[] arr = str.toCharArray();
				boolean flag = true;
				for(int i=0;i<arr.length;i++){
					if(!(arr[i]>='0' && arr[i]<='9')){
						flag = false;
						break;
					}
				}
				if(flag){
					System.out.println("qq:"+str);
				}
				else{
					System.out.println("���ַǷ��ַ�");
				}
			}
			else{
			System.out.println("������0��Ϊ��ͷ");
			}
		}
		else
			System.out.println("���ڷ�Χ��");
	}
	
	

	//2��ʹ��ת�����쳣�ж�(String�ࣩ
	public static void checkQQ_2(String str){
		int len = str.length();
		if(len>=5 && len<=15){
			if(!str.startsWith("0")){
				try {
					
					long l = Long.parseLong(str);
					System.out.println("qq:"+l);
				} catch (NumberFormatException e) {
					System.out.println("��ʽ����");
				}
			}
			else 
				System.out.println("������0��ͷ");
		}
		else
			System.out.println("���ȴ���");
	}
	
	
	
	//3��ʹ��������ʽ
	public static void check_3(String str){
		
		String regex = "[1-9][0-9]{4,14}";
		boolean flag = str.matches(regex);
		if(flag)
			System.out.println("qq:"+str);
		else
			System.out.println("������");
	}
	
	
	public static void main(String[] args) {
		
		while(true){
			Scanner s = new Scanner(System.in);
			String str = s.next();
			if ("over".equals(str)) 
				System.exit(0);
//			checkQQ_1(str);
//			checkQQ_2(str);
			check_3(str);
			
		}
		
	}
	
}
