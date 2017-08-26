package regex_text;

import java.util.Scanner;

/*
 * 正则表达式
 * 
 * 需求：校验qq号
 * 		5~15位，不能以0开头，只能是数字。
 */

public class RegexText {

	//1、普通判断方法 (String类)
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
					System.out.println("出现非法字符");
				}
			}
			else{
			System.out.println("不能以0作为开头");
			}
		}
		else
			System.out.println("不在范围内");
	}
	
	

	//2、使用转换，异常判断(String类）
	public static void checkQQ_2(String str){
		int len = str.length();
		if(len>=5 && len<=15){
			if(!str.startsWith("0")){
				try {
					
					long l = Long.parseLong(str);
					System.out.println("qq:"+l);
				} catch (NumberFormatException e) {
					System.out.println("格式错误");
				}
			}
			else 
				System.out.println("不能以0开头");
		}
		else
			System.out.println("长度错误");
	}
	
	
	
	//3、使用正则表达式
	public static void check_3(String str){
		
		String regex = "[1-9][0-9]{4,14}";
		boolean flag = str.matches(regex);
		if(flag)
			System.out.println("qq:"+str);
		else
			System.out.println("不符合");
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
