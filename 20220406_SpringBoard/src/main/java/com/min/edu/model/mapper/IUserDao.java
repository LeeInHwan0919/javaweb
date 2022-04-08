package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserDao {

	public UserVo getLogin(Map<String, Object> map);
	
	public int signupMember(UserVo vo);
	
	public int isDuplicateCheck(String id);
	
	public String findId(Map<String, Object> map);
	
	public int changeAuthToA(Map<String, Object> map);
	public int changeAuthToU(Map<String, Object> map);
	public int changeAuthToY(Map<String, Object> map);
	public int changeAuthToN(Map<String, Object> map);
	
	public List<UserVo> getAllUser();
}
