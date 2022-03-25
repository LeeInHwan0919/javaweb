package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.UserDto;

public interface IUserDao {
	
	public int userInsert(List<UserDto> dtos);
	
	public UserDto selectId(String dto);
}
