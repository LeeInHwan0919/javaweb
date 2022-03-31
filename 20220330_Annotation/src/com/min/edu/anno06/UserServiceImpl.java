package com.min.edu.anno06;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// spring bean configuration을 사용하지 않고 Annotation으로 등록하는 방법은 stereoType을 사용하면 됨
public class UserServiceImpl implements IUserService {

	// 생성되어 있는 다른 Bean을 주입(DI Dependency Injection)
	
	@Autowired
	@Qualifier("userDto")
	private UserDto dto1;
	
//	@Autowired//생성자 주입은 생성된 하나의 bean만을 사용할 수 있다 따라서 Qualifier는 사용할 수 없다.
	
	public UserServiceImpl(UserDto dto1) {
		this.dto1 = dto1;
	}

	public void setDto1(UserDto dto1) {
		this.dto1 = dto1;
	}


	@Override
	public void addUser() {
		System.out.println("Added Member : "+dto1.getName());
	}


	
	
}
