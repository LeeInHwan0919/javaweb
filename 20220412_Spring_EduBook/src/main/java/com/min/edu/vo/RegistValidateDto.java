package com.min.edu.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistValidateDto {

	@NotNull(message="널이 입력 되었습니다.")
	@Size(min=1,max=10,message="아이디 1~10사이의 값을 입력해 주세요.")
	private String id;
	@NotNull(message="널이 입력 되었습니다.")
	@Size(min=1,max=10,message="잘못된 이름 입력값 입니다.")
	private String name;
	@NotNull(message="널이 입력 되었습니다.")
	@Size(min=1,max=20,message="잘못된 패스워드 입력값 입니다.")
	private String pw;
	
	private String Auth;
	private String delFlag;
	private Date regdate;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAuth() {
		return Auth;
	}
	public void setAuth(String auth) {
		Auth = auth;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public RegistValidateDto(String id, String name, String pw, String auth, String delFlag, Date regdate) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		Auth = auth;
		this.delFlag = delFlag;
		this.regdate = regdate;
	}
	public RegistValidateDto() {
	}
	@Override
	public String toString() {
		return "RegistValidateDto [id=" + id + ", name=" + name + ", pw=" + pw + ", Auth=" + Auth + ", delFlag="
				+ delFlag + ", regdate=" + regdate + "]";
	}
	
	
}
