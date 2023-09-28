package com.web.user.dao;

public class Register {
	private String email;
	private String pwd;
	private String name;
	private String tel;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Register(String name, String email, String pwd, String tel) {
	  this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.tel = tel;
	}
	public Register() {	}
}
