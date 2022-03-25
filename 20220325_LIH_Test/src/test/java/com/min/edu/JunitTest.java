package com.min.edu;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.UserDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class JunitTest {

	private SqlSessionFactory manager;
	
	@Test
	public void select() {
		SqlSession session =  manager.openSession();
		UserDto a = session.selectOne("com.min.edu.model.UserDaoImpl.selectId", new UserDto("ldkkoj111"));
		System.out.println(a);
	}
	
//	@Test
	public void insert() {
		SqlSession session =  manager.openSession();
		int cnt = session.insert("com.min.edu.model.UserDaoImpl.userInsert",
				new UserDto("ldkkoj777","123456","이인환2","2022-02-02"));
		assertEquals("입력성공",cnt,1);
	}
	
	@Before
	public void test() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
}
