package com.mozzle.web.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class UserDto {
//	USER_ID, USER_PW, USER_NAME, AUTH_CODE, BIRTH, EMAIL, TEL, DELFLAG
	private String user_id;
	private String user_pw;
	private String user_name;
	private	String auth;
	private String birth;
	private String email;
	private String tel;
	private String delflag;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(String user_id, String user_pw, String user_name, String auth, String birth, String email,
			String tel, String delflag) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.auth = auth;
		this.birth = birth;
		this.email = email;
		this.tel = tel;
		this.delflag = delflag;
	}
	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", auth=" + auth
				+ ", birth=" + birth + ", email=" + email + ", tel=" + tel + ", delflag=" + delflag + "]";
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	

}
