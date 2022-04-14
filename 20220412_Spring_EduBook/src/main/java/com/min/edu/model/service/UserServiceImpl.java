package com.min.edu.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class); 
	
	@Autowired
	private IUserDao dao;
	
	@Override
	public UserVo login(UserVo vo) {
		logger.info("UserServiceImpl login : {}",vo);
		return dao.login(vo);
	}

}
