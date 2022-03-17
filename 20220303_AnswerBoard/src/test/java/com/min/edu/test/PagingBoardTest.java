package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.AnswerBoardDto;
import com.min.edu.model.IPagingDao;
import com.min.edu.model.PagingDaoImpl;

public class PagingBoardTest {

//	@Test
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		List<AnswerBoardDto> lists = session.selectList("com.min.edu.model.PagingDaoImpl.boardPaging",0);
		System.out.println(lists.size());
	}
	
	@Test
	public void test2() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		Integer cnt = session.selectOne("com.min.edu.model.PagingDaoImpl.rowCount");
		System.out.println(cnt);
	}

}
