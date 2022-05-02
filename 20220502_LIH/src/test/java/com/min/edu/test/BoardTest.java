package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardTest {

//	@Autowired
//	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IBoardDao dao;

//	@Test
	public void tamplateTest() {
//		assertNotNull(sqlSession);
	}

//	@Test
	public void insertBoard() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", 1);
		map.put("id", "USER");
		map.put("title", "insertBoard테스트");
		int cnt = dao.insertBoard(map);
		System.out.println("cnt:"+cnt);
	}
	
//	@Test
	public void replyUpdate() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", 1);
		int cnt = dao.replyUpdate(map);
		System.out.println("cnt:"+cnt);
	}
	
//	@Test
	public void replyInsert() {
//		BoardVo vo = new BoardVo(4, "USER", "replyInsert 답글작성테스트", "답글내용입니다.", 0, 0, 0, 0, null, null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", 278);
		map.put("id", "USER");
		map.put("title", "replyInsert답글작성테스트");
		map.put("content", "replyInsert답글내용입니다");
		int cnt = dao.replyInsert(map);
		System.out.println("cnt:"+cnt);
	}
	
//	@Test
	public void selectDetail() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", 278);
		BoardVo list = dao.selectDetail(map);
		System.out.println(list);
	}
//	@Test
	public void ReadCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", 278);
		int cnt = dao.ReadCount(map);
		System.out.println("cnt:"+cnt);
	}
//	@Test
	public void BoardUpdate() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", 278);
		map.put("title", "replyInsert답글작성테스트");
		map.put("content", "replyInsert답글내용입니다");
		int cnt = dao.BoardUpdate(map);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void selectAllBoard() {
		List<BoardVo> lists = dao.selectAllBoard();
		System.out.println(lists);
	}
	
//	@Test
	public void selectDown() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", 2);
		List<BoardVo> lists = dao.selectDown(map);
		System.out.println(lists);
	}
	
	
//	@Test
	public void MultipleDelete(){
		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] seqs = {"1","2"};
		map.put("seqs",seqs);
		int cnt = dao.MultipleDelete(map);
		System.out.println("cnt:"+cnt);
		}
	
	
	/*
	 * 페이징
	 */
	
//	@Test
	public void boardPaging() {
		int page = 0;
		List<BoardVo> lists = dao.boardPaging(page);
		System.out.println(lists);
	}
	
//	@Test
	public void rowCount() {
		int cnt = dao.rowCount();
		System.out.println(cnt);
	}
	
	
}
