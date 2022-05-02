package com.min.edu.vo;

public class MemberVo {

	private String id;
	private String pw;
	private String name;
	private String email;
	
	private String auth;
	private String delflag;
	private String regdate;
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", auth=" + auth
				+ ", delflag=" + delflag + ", regdate=" + regdate + "]";
	}
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String id, String pw, String name, String email, String auth, String delflag, String regdate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.auth = auth;
		this.delflag = delflag;
		this.regdate = regdate;
	}
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

	

}
