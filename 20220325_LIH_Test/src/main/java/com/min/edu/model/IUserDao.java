package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.UserDto;

public interface IUserDao {
	
	public int selectUser(Map<String, Object> map);
	
	public int insertUser(UserDto dto);
	
	public int idCheck(String id);
}
