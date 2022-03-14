package com.min.edu.dto;

public class UserVO {
	private String name;
	private String id;
	private String auth;
	
	public UserVO() {
		super();
	}
	
	
	
	public UserVO(String name, String id, String auth) {
		this.name = name;
		this.id = id;
		this.auth = auth;
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
	
	@Override
	public String toString() {
		return "UserVO [name=" + name + ", id=" + id + ", auth=" + auth + "]";
	}
}