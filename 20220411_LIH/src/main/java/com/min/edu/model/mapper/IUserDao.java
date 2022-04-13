package com.min.edu.model.mapper;

import java.util.List;

import com.min.edu.vo.UserVo;

public interface IUserDao {

	public List<UserVo> signIn(UserVo vo);
		
	public int signUp(UserVo vo);
	
}
