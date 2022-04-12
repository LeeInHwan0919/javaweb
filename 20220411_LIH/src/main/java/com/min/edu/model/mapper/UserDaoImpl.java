package com.min.edu.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDaoImpl implements IUserDao {
	
	private final String NS="com.min.edu.model.mapper.UserDaoImpl.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<UserVo> signIn(UserVo vo) {
		log.info("UserDaoImpl signIn 파라미터값 {}",vo);
		return sqlSession.selectList(NS+"signIn",vo);
	}


	@Override
	public int signUp(UserVo vo) {
		log.info("UserDaoImpl signUp 파라미터값 {}",vo);
		return sqlSession.insert(NS+"signUp",vo);
	}
	
	

}
