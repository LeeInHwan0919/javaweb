package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.MemberVo;

@Repository
public class MemberDaoImpl implements IMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.min.edu.model.mapper.MemberDaoImpl.";
	@Override
	public List<MemberVo> selectMemberAll() {
		return sqlSession.selectList(NS+"selectMemberAll");
	}

	@Override
	public int insertMember(Map<String, Object> map) {
		return sqlSession.insert(NS+"insertMember",map);
	}

	@Override
	public MemberVo loginMember(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"loginMember",map);
	}

	@Override
	public int passwordCheck(String pw) {
		return sqlSession.selectOne(NS+"passwordCheck",pw);
	}

}
