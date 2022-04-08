package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

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
	public UserVo getLogin(Map<String, Object> map) {
		logger.info("UserServiceImpl 로그인 getLogin: {}",map);
		return dao.getLogin(map);
	}

	@Override
	public int signupMember(UserVo vo) {
		logger.info("signupMember 회원가입 vo파라미터:{}",vo);
		return dao.signupMember(vo);
	}

	@Override
	public int isDuplicateCheck(String id) {
		logger.info("isDuplicateCheck 중복체크 파라미터 값:{}",id);
		return dao.isDuplicateCheck(id);
	}

	@Override
	public String findId(Map<String, Object> map) {
		return dao.findId(map);
	}

	@Override
	public int changeAuthToA(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeAuthToA(map);
	}

	@Override
	public int changeAuthToU(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeAuthToU(map);
	}

	@Override
	public int changeAuthToY(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeAuthToY(map);
	}

	@Override
	public int changeAuthToN(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeAuthToN(map);
	}

	@Override
	public List<UserVo> getAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}
	
	

}
