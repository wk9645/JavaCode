package com.wk.entity;


/*
 * 1������Ա����
 */
public class Admin {

	private String adminName;	//�û���
	private String pwd;			//����
	
	
	//�޲ι��캯��
	public Admin() {}
	
	//���ι��캯��
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
