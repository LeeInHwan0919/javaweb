package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.UserVo;

public interface IUserDao {
	public UserVo login(Map<String, Object> map);
}
