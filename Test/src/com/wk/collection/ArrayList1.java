package com.wk.collection;


import java.util.ArrayList;
import java.util.Iterator;

/*
 * ��һ��ArryList�д�һ�����󣬲�ȥ���ظ�Ԫ��
 * 
 * 
 */
/*
class Person{
	private String name;
	private int age;
	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}


public class ArrayList1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ArrayList aList = new ArrayList();
		Iterator iterator = aList.iterator();
		aList.add(new Person("����", 35));
		aList.add(new Person("����", 36));
		aList.add(new Person("����", 37));
		aList.add(new Person("С��", 38));
		
		while(iterator.hasNext()){
			Person p = (Person)iterator.next();
			System.out.println(p.getName()+" "+p.getAge());
		}
	}
}*/

import java.sql.*;
public class ArrayList1 {
public static void main(String[] args) {
      String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
      String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=JinXiaoCun";// ����Դ
      try {
          Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
      } catch (ClassNotFoundException e) {
          // e.printStackTrace();
          System.out.println("�������ݿ�����ʧ��");
          System.exit(0);
      }
      System.out.println("���ݿ������ɹ�");
      try {


          String user = "sa";
          String password = "123";
          Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
          System.out.println("�������ݿ�ɹ�");
          Statement stmt = con.createStatement();// ����SQL�������
          // ������
          System.out.println("��ʼ������");
          String query = "create table TABLE1(ID NCHAR(2),NAME NCHAR(10))";// ������SQL���
          stmt.executeUpdate(query);// ִ��SQL�������
          System.out.println("�����ɹ�");
          // ��������
          System.out.println("��ʼ��������");
          String a1 = "INSERT INTO TABLE1 VALUES('1','���')";// ��������SQL���
          String a2 = "INSERT INTO TABLE1 VALUES('2','ΰ��')";
          String a3 = "INSERT INTO TABLE1 VALUES('3','�Ÿ�')";
          stmt.executeUpdate(a1);// ִ��SQL�������
          stmt.executeUpdate(a2);
          stmt.executeUpdate(a3);
          System.out.println("�������ݳɹ�");
          // ��ȡ����
          System.out.println("��ʼ��ȡ����");


          ResultSet rs = stmt.executeQuery("SELECT * FROM TABLE1");// ����SQL����ѯ�����(����)
          // ѭ�����ÿһ����¼
          while (rs.next()) {
              // ���ÿ���ֶ�
              System.out.println(rs.getString("ID") + "\t" + rs.getString("NAME"));
          }
          System.out.println("��ȡ���");
          // �ر�����
          stmt.close();// �ر������������
          con.close();// �ر����ݿ�����
      } catch (SQLException e) {
          e.printStackTrace();
          System.out.println("���ݿ����Ӵ���");
          System.exit(0);
      }
  }
}





