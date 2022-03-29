package com.min.edu.bean3;

import javax.annotation.Resource;

public class UserServiceImpl implements IUserService {

	@Resource(name="myDto")
	private UserDto dto;
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 생성자");
	}
	
	@Override
	public void addUser(UserDto dto) {
		System.out.println("addUser 메소드 호출" + dto);
		System.out.println("addUser 메소드 호출" + this.dto);
	}

}
