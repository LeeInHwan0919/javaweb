package com.min.edu.model.service;

import java.util.List;

import com.min.edu.vo.UserVo;

public interface IUserService {

	public List<UserVo> signIn(UserVo vo);

	public int signUp(UserVo vo);
}
