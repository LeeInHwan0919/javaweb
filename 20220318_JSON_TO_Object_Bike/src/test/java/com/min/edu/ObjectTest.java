package com.min.edu;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.BikeDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class ObjectTest {

	private SqlSessionFactory manager;
	
	@Test
	public void insert() {
		SqlSession session =  manager.openSession();
		int cnt = session.insert("com.min.edu.model.BikeDaoImpl.bikeInsert",
				new BikeDto("화양동 169-1",500,"광진구",127.074272,10,37.54707,"어린이대공원역 3번출구 앞")	);
		assertEquals("입력성공",cnt,1);
	}
	
	@Before
	public void test() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
}
