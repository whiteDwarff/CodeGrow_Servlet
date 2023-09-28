package com.web.user.dto;

public class LoginDto {
	
	private String email;
	private String pwd;
	
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
	public LoginDto(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}
	public LoginDto() {}
	
}
