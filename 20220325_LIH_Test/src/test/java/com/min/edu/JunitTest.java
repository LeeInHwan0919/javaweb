package com.min.edu;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.dto.UserDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;



public class JunitTest {

	private SqlSessionFactory manager =  SqlSessionFactoryManager.getFactory();
	private String NS = "com.min.edu.model.UserDaoImpl.";
	
//	@Test
	public void selectUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "ldkkoj111");
		map.put("password", "123456");
		SqlSession session = manager.openSession();
		int cnt = session.selectOne(NS+"selectUser",map);
		System.out.println(cnt);
	}
	
	@Test
	public void insertUser() {
		UserDto dto = new UserDto("ldkkoj000","123456","이인환");
        SqlSession session = manager.openSession(true);
        int cnt = session.insert(NS+"insertUser",dto);
        assertEquals(cnt, 1);
	}
	

	
}
