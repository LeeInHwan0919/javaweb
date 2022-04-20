package com.min.edu.model.mapper;

import java.util.List;

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
	public int signUp(MemberVo vo) {
		return sqlSession.insert(NS+"signUp",vo);
	}

	@Override
	public int login(MemberVo vo) {
		return sqlSession.selectOne(NS+"login",vo);
	}

	@Override
	public String confirmPw(String id) {
		return sqlSession.selectOne(NS+"confirmPw",id);
	}

	
	

	
	
}
