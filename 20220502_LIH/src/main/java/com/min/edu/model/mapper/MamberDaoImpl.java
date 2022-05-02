package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.MemberVo;

@Repository
public class MamberDaoImpl implements IMemberDao {

	private final String NS = "com.min.edu.model.mapper.MemberDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MemberVo> selectAllMember() {
		return sqlSession.selectList(NS+"selectAllMember");
	}

	@Override
	public int signUp(Map<String, Object> map) {
		return sqlSession.insert(NS+"signUp",map);
	}

	@Override
	public int login(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"login",map);
	}

	@Override
	public String confirmPw(String id) {
		return sqlSession.selectOne(NS+"confirmPw",id);
	}

	@Override
	public String findID(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"findID",map);
	}

	
	

	
	
}
