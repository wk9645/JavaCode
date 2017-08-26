package com.wk.reflectGen;

import java.sql.SQLException;
import java.util.List;

import com.wk.entity.Admin;


public class Test {
	public static void main(String[] args) {
		
		String str = "ÁªÍ¨";
		byte[] bytes = str.getBytes();
		for (byte b : bytes) {
			
			System.out.println(Integer.toBinaryString(b));
		}
		
	}
	
	
	@org.junit.Test
	public void test() throws SQLException{
		
		AdminDao aDao = new AdminDao();
//		Admin admin = aDao.findById(6);
		
		List<Admin> admins = aDao.findAll();
//		System.out.println(admin);
		
		System.out.println(admins);
	}
}
