package com.web.user.dto;

import java.util.Date;

public class UserDto {
	
	private String email;
	private String pwd;
	private String name;
	private String tel;
	private Date regDate;
	private int number;
	
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date redDate) {
		this.regDate = redDate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public UserDto(String email, String pwd, String name, String tel, Date regDate, int number) {

		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.regDate = regDate;
		this.number = number;
	}
	public UserDto() {}
	
}
