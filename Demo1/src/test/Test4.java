package test;

import java.io.File;

import pocketmine.utils.Utils;

public class Test4 {
/* ±£´æ */
	public static void main(String[] args) throws Exception {
		byte[] s1=Utils.readFile(new File("test"));
		System.out.println(s1.length);
		Utils.writeFile(new File("test2"), s1);
		System.gc();
		byte[] s3=Utils.readFile(new File("test2"));
		boolean r=true;
		if(s1.length==s3.length){
		for(int i=0;i<s1.length;i++){
			if(s1[i]!=s3[i]){
				r=false;
				break;
			}
		}
		}else{
		r=false;	
		}
		System.out.println(r);
	}
}
