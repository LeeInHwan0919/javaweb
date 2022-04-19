package com.min.edu.model.service;

import java.util.List;

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
	public int signUp(MemberVo vo) {
		logger.info("MemberServiceImpl signUp 파라미터 값 vo: {}",vo);
		return dao.signUp(vo);
	}

	@Override
	public int login(MemberVo vo) {
		logger.info("MemberServiceImpl login 파라미터 값 vo: {}",vo);
		return dao.login(vo);
	}

	@Override
	public String confirmPw(String id) {
		logger.info("MemberServiceImpl confirmPw 파라미터 값 id : {}",id);
		return dao.confirmPw(id);
	}
	
	

}
