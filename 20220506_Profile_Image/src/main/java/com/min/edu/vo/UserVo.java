package com.min.edu.vo;

import java.io.Serializable;

public class UserVo implements Serializable{
	
	private static final long serialVersionUID = 6040994051421692702L;
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String auth;
	private String delflag;
	private String regdate;
	private String proimg;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getProimg() {
		return proimg;
	}
	public void setProimg(String proimg) {
		this.proimg = proimg;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", auth=" + auth
				+ ", delflag=" + delflag + ", regdate=" + regdate + ", proimg=" + proimg + "]";
	}
	public UserVo(String id, String pw, String name, String email, String auth, String delflag, String regdate,
			String proimg) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.auth = auth;
		this.delflag = delflag;
		this.regdate = regdate;
		this.proimg = proimg;
	}
	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
