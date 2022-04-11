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
		logger.info("UserServiceImpl 로그인 getLogin : {}",map );
		return dao.getLogin(map);
	}

	@Override
	public int isDuplicateCheck(String id) {
		logger.info("UserServiceImpl 아이디 중복 검사 : {}",id );
		return dao.isDuplicateCheck(id);
	}

	@Override
	public int singupMember(UserVo vo) {
		logger.info("UserServiceImpl 회원가입 singupMember : {}",vo );
		return dao.singupMember(vo);
	}

	@Override
	public List<UserVo> userSelectAll() {
		logger.info("UserServiceImpl 회원전체조회");
		return dao.userSelectAll();
	}

	@Override
	public UserVo userSelectOne(String id) {
		logger.info("UserServiceImpl 회원상세조회 : {}",id);
		return dao.userSelectOne(id);
	}

	@Override
	public List<UserVo> getSearchUser(String opt, String keyword) {
		logger.info("UserServiceImpl 회원검색 : {},{}",opt, keyword);
		return dao.getSearchUser(opt, keyword);
	}

	@Override
	public String findId(Map<String, Object> map) {
		logger.info("UserServiceImpl findId 실행");
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
	public int changeDelflagToN(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeDelflagToN(map);
	}

	@Override
	public int changeDelflagToY(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.changeDelflagToY(map);
	}

	@Override
	public List<UserVo> getAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}
}




