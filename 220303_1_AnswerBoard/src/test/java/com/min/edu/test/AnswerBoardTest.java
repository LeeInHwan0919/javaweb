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

	private final String NS = "com.min.edu.model.AnswerBoardDaoImpl.";
	SqlSessionFactory manager = null;
	
	@Before
	public void test() {
		manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
//		assertNotNull("생성", session);
		assertNotNull(manager);
	}
	
	//@Test
	public void selectAllBoard(){
		SqlSession session = manager.openSession();
		List<AnswerBoardDto> lists = session.selectList(NS+"selectAllBoard");
		System.out.println(lists);
	}
	
	//@Test
	public void selectDetailBoard() {
		SqlSession session = manager.openSession();
		AnswerBoardDto dto = session.selectOne(NS+"selectDetailBoard", 2);
		System.out.println(dto);
	}

	@Test
	public void reply() {
		
		AnswerBoardDto dto = 
				new AnswerBoardDto(11, "M002", 
						"지금 테스트 통합 reply로 넣은 답글 제목", " 지금 테스트 통합 reply로 넣은 답글 내용");
		
		SqlSession session = manager.openSession(true);
		int replyIn = session.update(NS+"replyUpdate",dto);
	 	int replyUp = session.insert(NS+"replyInsert",dto);
	}
	 
//	@Test
	public void deleteBoard() {
		SqlSession session = manager.openSession(true); 
		int dto = session.update(NS+"deleteBoard", "2");
	}
	
//	@Test
	public void modifyBoard() {
		SqlSession session = manager.openSession(true); 
		Map map = new HashMap<String, String>();
		map.put("con", "Map으로 수정한 글");
		map.put("seq", "2");
		session.update(NS+"modifyBoard", map);
	}
	
//	@Test
	public void insertBoard() {
		AnswerBoardDto dto = 
				new AnswerBoardDto("Q007", "새로 insertBoard로 넣은 글 제목"
						, "새로 insertBoard로 넣은 글 내용");
		
		SqlSession session = manager.openSession(true); 
		session.insert(NS+"insertBoard", dto);
	}
}
