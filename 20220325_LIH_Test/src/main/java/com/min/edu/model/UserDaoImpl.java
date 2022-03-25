package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class UserDaoImpl implements IUserDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.UserDaoImpl.";
	
	@Override
	public int userInsert(List<UserDto> dtos) {
		logger.info("UserDaoImpl userInsert: "+dtos.size());
		int cnt=0;
		SqlSession session = manager.openSession();
		for (UserDto dto : dtos) {
			cnt += session.insert(NS+"userInsert",dto);
		}
		session.commit();
		return cnt;
	}

	@Override
	public UserDto selectId(String str) {
		logger.info("아이디가 있는지 검사");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"selectId", str);
	}
	
	
	


}
