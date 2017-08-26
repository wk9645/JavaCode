package com.wk.entity;

import com.wk.annotations.Column;
import com.wk.annotations.Id;
import com.wk.annotations.Table;

@Table(tableName="a_admin")
public class Admin {

	@Id
	@Column(columnName="a_id")
	private int id;
	
	@Column(columnName="a_uerName")
	private String userName;
	
	@Column(columnName="a_password")
	private String password;
	
	public Admin() {}
	
	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ",userName=" + userName + ", password=" + password + "]";
	}
	
	
}
