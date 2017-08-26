package regex_text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 正则表达式
 * 
 * 1、匹配
 * 
 * 2、切割
 * 
 * 3、替换
 * 
 * 4、获取
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
	
	
	//匹配
	public static void matchText(String str){
		
		
	}
	
	//切割
	public static void splidText(String str){
		String regex = "\\.";   //使用小数点切割
		
//		String regex = "\\\\"; //切割目录
		
//		String regex = "(.)\\1+";  //以叠词为切割点,括号代表一组,从1开始，1指定为第一组
		
		String[] result = str.split(regex);
		for(String num : result){
			System.out.println(num);
		}
	}
	
	
	//替换
	public static void replaceText(String str){
		
//		str = str.replaceAll("\\d+","*" );   //将所有数字替换为*
		
		str = str.replaceAll("(.)\\1+", "$1");  //将所有连续出现的字符替换为单个字符
		
		System.out.println(str);
	}
	
	/*
	 * 
	 * 步骤：
	 * 		1、将正则表达式封装成对象
	 * 		2、让正则对象和要操作的字符串相关联,获取匹配器对象
	 * 		3、关联后，获取正则表达式引擎
	 * 		4、通过引擎对符合的子字符串进行操作
	 * 
	 */
	
	
	//获取
	public static void obtainText(String str){
		
		String regex = "\\b[a-z]{3}\\b";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		
//		System.out.println(m.matches()); 
		
		//取出指定规则子字符串
		
		while(m.find()){
			System.out.println(m.group());
			System.out.println(m.start()+"...."+m.end());
			
		}
		
	}
}
