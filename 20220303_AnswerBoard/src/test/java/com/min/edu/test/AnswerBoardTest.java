package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.AnswerBoardDto;

public class AnswerBoardTest {
	
	private final String NS ="com.min.edu.model.AnswerBoardDaoImpl.";
	private SqlSessionFactory manager = null;
	
	@Before
	public void test() {
		manager = SqlSessionFactoryManager.getFactory();
//		SqlSession session = manager.openSession();
//		assertNotNull("생성",session);
		assertNotNull(manager);
	}
	

	
//	@Test
	public void selectAllBoard() {
		SqlSession session = manager.openSession();
		List<AnswerBoardDto> lists = session.selectList(NS+"selectAllBoard");
		System.out.println(lists);
	}
	
//	@Test
	public void selectDetailBoard() {
		SqlSession session = manager.openSession();
		AnswerBoardDto dto = session.selectOne(NS+"selectDetailBoard",3);
		System.out.println(dto);
	}
//	@Test
	public void reply() {
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"replyUpdate", 2);
		System.out.println(row);
		AnswerBoardDto dto = new AnswerBoardDto(2, "Q003", "test답글3입니다", "test답글3달아요");
		int row2 = session.update(NS+"replyInsert", dto);
		System.out.println(row2);
	}
//	@Test
	   public void deleteBoard() {
	      SqlSession session = manager.openSession(true);
	      int row = session.update(NS+"deleteBoard","1");
	      System.out.println(row);
	   }
//	@Test
	   public void modifyBoard() {
		      SqlSession session = manager.openSession(true);
		      Map<String, Object> map = new HashMap<String, Object>();
		      map.put("con", "수정된내용test");
		      map.put("seq", 3);
		      int row = session.update(NS+"modifyBoard",map);
		      System.out.println(row);
		   }
//	@Test
	   public void insertBoard() {
		      SqlSession session = manager.openSession(true);
		      AnswerBoardDto dto = new AnswerBoardDto("Q005","두번째 새글test","새글 입력입니다.test");
		      int row = session.insert(NS+"insertBoard", dto);
		      System.out.println(row);
		   }


}
