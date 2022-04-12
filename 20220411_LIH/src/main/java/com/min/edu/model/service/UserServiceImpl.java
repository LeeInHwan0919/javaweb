package com.min.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private IUserDao dao;

	@Override
	public List<UserVo> signIn(UserVo vo) {
		log.info("UserServiceImpl signIn 파라미터값 {}",vo);
		return dao.signIn(vo);
	}

	@Override
	public int signUp(UserVo vo) {
		log.info("UserServiceImpl signUp 파라미터값 {}",vo);
		return dao.signUp(vo);
	}

	
}
