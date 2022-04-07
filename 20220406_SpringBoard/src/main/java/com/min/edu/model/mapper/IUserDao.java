package com.min.edu.model.mapper;

import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserDao {

	public UserVo getLogin(Map<String, Object> map);
	
	public int signupMember(UserVo vo);
	
	public int isDuplicateCheck(String id);
}
