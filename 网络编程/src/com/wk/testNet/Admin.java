package com.wk.testNet;

import java.io.Serializable;

public class Admin implements Serializable{

	
	private static final long serialVersionUID = -3372077379624197508L;
	private String name;
	private String pwd;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
