package regex_text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ������ʽ
 * 
 * 1��ƥ��
 * 
 * 2���и�
 * 
 * 3���滻
 * 
 * 4����ȡ
 * 
 */

public class RegexText2 {
	public static void main(String[] args) {
		String str = "ming tian yao qu xian yan shi xi";
		str = "aaabbbccddd";
		
//		splidText(str);
		replaceText(str);
//		obtainText(str);
	}
	
	
	//ƥ��
	public static void matchText(String str){
		
		
	}
	
	//�и�
	public static void splidText(String str){
		String regex = "\\.";   //ʹ��С�����и�
		
//		String regex = "\\\\"; //�и�Ŀ¼
		
//		String regex = "(.)\\1+";  //�Ե���Ϊ�и��,���Ŵ���һ��,��1��ʼ��1ָ��Ϊ��һ��
		
		String[] result = str.split(regex);
		for(String num : result){
			System.out.println(num);
		}
	}
	
	
	//�滻
	public static void replaceText(String str){
		
//		str = str.replaceAll("\\d+","*" );   //�����������滻Ϊ*
		
		str = str.replaceAll("(.)\\1+", "$1");  //�������������ֵ��ַ��滻Ϊ�����ַ�
		
		System.out.println(str);
	}
	
	/*
	 * 
	 * ���裺
	 * 		1����������ʽ��װ�ɶ���
	 * 		2������������Ҫ�������ַ��������,��ȡƥ��������
	 * 		3�������󣬻�ȡ������ʽ����
	 * 		4��ͨ������Է��ϵ����ַ������в���
	 * 
	 */
	
	
	//��ȡ
	public static void obtainText(String str){
		
		String regex = "\\b[a-z]{3}\\b";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		
//		System.out.println(m.matches()); 
		
		//ȡ��ָ���������ַ���
		
		while(m.find()){
			System.out.println(m.group());
			System.out.println(m.start()+"...."+m.end());
			
		}
		
	}
}
