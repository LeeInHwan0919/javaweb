package com.min.edu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.vo.UserVo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	@Override
	public boolean insertUser(UserVo vo) {
		System.out.println("UserServiceImpl insertUser : "+vo);
		return dao.insertUser(vo);
	}

}
