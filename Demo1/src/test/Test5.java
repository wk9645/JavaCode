package test;
import java.io.File;
import pocketmine.utils.Utils;


public final class Test5 {

	/**
	 * Ñ¹Ëõ
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		byte[] s1=Utils.readFile(new File("test"));
		System.out.println(s1.length);
		byte[] s2=Utils.deflate(s1, 9);
		byte[] s4=Utils.inflate(s2);
		boolean r=true;
/*		if(s2.length==s3.length){*/
		for(int i=0;i<s1.length;i++){
			if(s1[i]!=s4[i]){
				r=false;
				System.out.println(i);
				break;
			}
		}
/*		}else{
		r=false;	
		}*/
		System.out.println(r);

		System.out.println(s1.length==s4.length);
	}

}
