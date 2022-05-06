package com.min.edu.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private final String NS = "com.min.edu.model.UserDaoImpl.";
	
	@Override
	public boolean insertUser(UserVo vo) {
		System.out.println("UserDaoImpl insertUser vo  : "+vo);
		int cnt = session.insert(NS+"insertUser",vo);
		return cnt>0?true:false;
	}

}
