package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.UserVo;

public class UserInfoDaoImpl implements IUserInfoDao{
	
	private Logger logger = Logger.getLogger(this.getClass());
	private String NS = "com.min.edu.model.UserInfoDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
	@Override
	public UserVo loginSelect(Map<String, Object> map) {
		logger.info("회원 로그인 loginSelect"+map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"loginSelect",map);
	}

}
