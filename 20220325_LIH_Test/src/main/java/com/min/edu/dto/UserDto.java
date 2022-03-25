package com.min.edu.dto;

public class UserDto {
	private String id;
	private String password;
	private String name; 
	private String regdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", name=" + name + ", regdate=" + regdate + "]";
	}
	public UserDto() {
		
	}
	public UserDto(String id, String password, String name, String regdate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.regdate = regdate;
	}
	
	public UserDto(String id) {
		this.id = id;
	}
	
	
	
	
	
	


}
