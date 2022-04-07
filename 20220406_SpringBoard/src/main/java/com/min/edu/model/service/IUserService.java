package com.min.edu.model.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.vo.UserVo;

public interface IUserService {

	
	public UserVo getLogin(Map<String, Object> map);
		
	public int signupMember(UserVo vo);
	
	public int isDuplicateCheck(String id);
}
