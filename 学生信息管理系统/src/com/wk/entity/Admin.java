package com.wk.entity;


/*
 * 1、管理员对象
 */
public class Admin {

	private String adminName;	//用户名
	private String pwd;			//密码
	
	
	//无参构造函数
	public Admin() {}
	
	//带参构造函数
	public Admin(String adminName, String pwd) {
		super();
		this.adminName = adminName;
		this.pwd = pwd;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", pwd=" + pwd + "]";
	}
	
}
