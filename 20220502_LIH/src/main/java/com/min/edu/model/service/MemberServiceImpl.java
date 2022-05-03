package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IMemberDao;
import com.min.edu.vo.MemberVo;

@Service
public class MemberServiceImpl implements IMemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class); 
	
	@Autowired
	private IMemberDao dao;

	@Override
	public List<MemberVo> selectAllMember() {
		logger.info("MemberServiceImpl selectAllMember");
		return dao.selectAllMember();
	}

	@Override
	public int signUp(Map<String, Object> map) {
		logger.info("MemberServiceImpl signUp 파라미터 값 map: {}",map);
		return dao.signUp(map);
	}

	@Override
	public MemberVo loginMember(Map<String, Object> map) {
		logger.info("MemberServiceImpl loginMember 파라미터 값 map: {}",map);
		return dao.loginMember(map);
	}


	@Override
	public String findID(Map<String, Object> map) {
		logger.info("MemberServiceImpl findID 파라미터 값 map : {}",map);
		return dao.findID(map);
	}

	@Override
	public String passwordCheck(String id) {
		logger.info("MemberServiceImpl passwordCheck 파라미터 값  : {}",id);
		return dao.passwordCheck(id);
	}

	@Override
	public MemberVo enLogin(String id) {
		logger.info("MemberServiceImpl enLogin 파라미터 값  : {}",id);
		return dao.enLogin(id);
	}
	
	

}
