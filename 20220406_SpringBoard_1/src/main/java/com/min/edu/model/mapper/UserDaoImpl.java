package com.min.edu.model.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

@Repository
public class UserDaoImpl implements IUserDao {
	
	private final String NS="com.min.edu.model.mapper.UserDaoImpl.";

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public UserVo getLogin(Map<String, Object> map) {
		return sqlSession.selectOne(NS +"getLogin" ,map);
	}

	@Override
	public int signupMember(UserVo vo) {
		return sqlSession.insert(NS+"signupMember",vo);
	}

	@Override
	public int isDuplicateCheck(String id) {
		return sqlSession.selectOne(NS+"isDuplicateCheck",id);
	}

}
