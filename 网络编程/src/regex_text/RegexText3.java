package regex_text;

/*
 * ������ʽ��ϰ
 * 	
 */


public class RegexText3 {
	
	public static void main(String[] args) {

		text1();
	}
	
	public static void text1(){
		
		String str = "����...����...��Ҫ..ҪҪ..ҪҪ..ѧѧѧ..ѧѧ..����..���..�̳̳�..��";
		
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		str = str.replaceAll("(\\W)\\1+", "$1");
		System.out.println(str);
	}
}
