package test;

import java.io.File;
import pocketmine.utils.Utils;

public class Test3 {
/* Ñ¹Ëõ±£´æ */
	public static void main(String[] args) throws Exception {
		byte[] s1=Utils.readFile(new File("test"));
		System.out.println(s1.length);
		byte[] s2=Utils.deflate(s1, 9);
		System.out.println(s2.length);
		Utils.writeFile(new File("test2"), s2);
		System.gc();
		byte[] s3=Utils.readFile(new File("test2"));
		System.out.println(Test3.verifyBin(s2,s3));
		byte[] s4=Utils.inflate(s3);
		System.out.println(Test3.verifyBin(s1,s4));
	}
	
	public static boolean verifyBin(byte[] a,byte[] b){
		boolean r=true;
		if(a.length==b.length){
		for(int i=0;i<a.length;i++){
			if(a[i]!=b[i]){
				r=false;
				System.out.println(i);
				break;
			}
		}
		}else{
		r=false;	
		}
		return r;
	}

}
