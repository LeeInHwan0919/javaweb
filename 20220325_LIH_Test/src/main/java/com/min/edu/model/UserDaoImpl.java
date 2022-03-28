package com.min.edu.model;

import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import com.min.edu.dto.UserDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class UserDaoImpl implements IUserDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.UserDaoImpl.";
	@Override
	public int selectUser(Map<String, Object> map) {
        SqlSession session = manager.openSession();
        int cnt = session.selectOne(NS+"selectUser",map);
        System.out.println("cnt의 값은 : "+cnt);
		return cnt;
	}
	@Override
	public int insertUser(UserDto dto) {
		SqlSession session = manager.openSession(true);
		int cnt = session.insert(NS+"insertUser",dto);
		System.out.println("cnt의 값은 : "+cnt);
		return cnt;
	}
	@Override
	public int idCheck(String id) {
		 SqlSession session = manager.openSession();
		int cnt = session.selectOne(NS+"idCheck",id);
		return cnt;
	}
	
	
	
	
	


}
