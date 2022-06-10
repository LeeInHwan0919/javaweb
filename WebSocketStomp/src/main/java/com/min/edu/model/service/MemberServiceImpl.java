package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IMemberDao;
import com.min.edu.vo.TestVo;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private IMemberDao dao;
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Override
	public List<TestVo> calenList() {
		logger.info("MemberServiceImpl calenList ");
		return dao.calenList();
	}

	@Override
	public boolean insertCal(Map<String, Object> map) {
		logger.info("MemberServiceImpl insertCal 넘어온 값 : {}",map);
		return dao.insertCal(map);
	}

	@Override
	public int dragUpdateCal(Map<String, Object> map) {
		logger.info("MemberServiceImpl dragUpdateCal 넘어온 값 : {}",map);
		return dao.dragUpdateCal(map);
	}

}
