package com.min.edu.vo;

public class MemberVo {
	
	 private String id      ;
	 private String pw      ;
	 private String auth    ;
	 private String delflag ;
	 private String regdate ;
	 
	 
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getPw() {
		return pw;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public MemberVo(String id, String pw, String auth, String delflag, String regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.auth = auth;
		this.delflag = delflag;
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pw=" + pw + ", auth=" + auth + ", delflag=" + delflag + ", regdate=" + regdate
				+ "]";
	}
	 
	 public MemberVo() {
		// TODO Auto-generated constructor stub
	}
}
