package com.min.edu.dto;

import java.io.Serializable;

public class UserVo implements Serializable{
	
	private static final long serialVersionUID = 7772458465857272341L;
	
	private String name;
	private String id;
	private String auth;
	private String email;
	private String delflag;
	private String joindate;
	private String password;
	
	public UserVo(String name2, String id2, String password2) {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserVo [name=" + name + ", id=" + id + ", auth=" + auth + ", email=" + email + ", delflag=" + delflag
				+ ", joindate=" + joindate + "]";
	}

	
	
}
