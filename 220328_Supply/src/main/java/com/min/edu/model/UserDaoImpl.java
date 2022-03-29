package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class UserDaoImpl implements IUserDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS ="com.min.edu.model.UserDaoImpl.";
	
	@Override
	public UserVo login(Map<String, Object> map) {
		logger.info("로그인 : "+map);
		SqlSession session = manager.openSession();
		UserVo vo = session.selectOne(NS+"login",map);
		session.close();
		return vo;
	}

}
