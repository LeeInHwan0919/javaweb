package com.min.edu.model.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

@Repository
public class UserDaoImpl implements IUserDao {

	private final String NS = "com.min.edu.model.mapper.UserDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public UserVo login(UserVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"login",vo);
	}
	

	
	
}
