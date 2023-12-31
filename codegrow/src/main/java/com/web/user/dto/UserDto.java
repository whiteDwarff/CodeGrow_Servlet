package com.web.user.dto;

import java.util.Date;

public class UserDto {
	private int id;
 private String email;
	private String pwd;
	private String name;
	private String tel;
	private Date regDate;
	private String rank;
	private int number;
	
 public int getId() {
   return id;
 }
 public void setId(int id) {
   this.id = id;
 }
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
 public String getRank() {
   return rank;
  }
  public void setRank(String rank) {
   this.rank = rank;
  }
	// 회원가입 시 사용
	public UserDto(int id, String email, String pwd, String name, String tel, Date regDate, String rank, int number) {
	 this.id = id;
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.regDate = regDate;
		this.rank = rank;
		this.number = number;
	}
	// 관리자 사용
 public UserDto(int id, String email, String name, String tel, Date regDate, String rank) {
   this.id = id;
   this.email = email;
   this.name = name;
   this.tel = tel;
   this.regDate = regDate;
   this.rank = rank;
  }
	public UserDto() {}
	
}
