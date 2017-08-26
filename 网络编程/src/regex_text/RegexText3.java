package regex_text;

/*
 * 正则表达式练习
 * 	
 */


public class RegexText3 {
	
	public static void main(String[] args) {

		text1();
	}
	
	public static void text1(){
		
		String str = "我我...我我...我要..要要..要要..学学学..学学..编编编..编程..程程程..程";
		
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		str = str.replaceAll("(\\W)\\1+", "$1");
		System.out.println(str);
	}
}
