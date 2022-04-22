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

	@Autowired
	private IMemberDao dao;
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Override
	public List<MemberVo> selectMemberAll() {
		logger.info("MemberServiceImpl selectMemberAll");
		return dao.selectMemberAll();
	}

	@Override
	public int insertMember(Map<String, Object> map) {
		logger.info("MemberServiceImpl insertMember : {}",map);
		return dao.insertMember(map);
	}

	@Override
	public MemberVo loginMember(Map<String, Object> map) {
		logger.info("MemberServiceImpl loginMember : {}",map);
		return dao.loginMember(map);
	}

	@Override
	public int passwordCheck(String pw) {
		logger.info("MemberServiceImpl passwordCheck : {}",pw);
		return dao.passwordCheck(pw);
	}

	@Override
	public MemberVo enLogin(String id) {
		logger.info("MemberServiceImpl enLogin : {}",id);
		return dao.enLogin(id);
	}

	@Override
	public int changeUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int idCheck(String id) {
		
		return dao.idCheck(id);
	}
	
	

}
