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

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IBoardDao dao;

//	@Test
	public void tamplateTest() {
		assertNotNull(sqlSession);
	}

//	@Test
	public void insertBoard() {
		BoardVo vo = new BoardVo(1, "USER", "junit 제목테스트", null, 0, 0, 0, 0, null, null);
		int cnt = dao.insertBoard(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void replyUpdate() {
		BoardVo vo = new BoardVo(4, null, null, null, 0, 0, 0, 0, null, null);
		int cnt = dao.replyUpdate(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void replyInsert() {
		BoardVo vo = new BoardVo(4, "USER", "junit 답글작성테스트", "답글내용입니다.", 0, 0, 0, 0, null, null);
		int cnt = dao.replyInsert(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void selectDetail() {
		BoardVo vo = new BoardVo(4, null, null, null, 0, 0, 0, 0, null, null);
		BoardVo list = dao.selectDetail(vo);
		System.out.println(list);
	}
//	@Test
	public void ReadCount() {
		BoardVo vo = new BoardVo(4, null, null, null, 0, 0, 0, 0, null, null);
		int cnt = dao.ReadCount(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
//	@Test
	public void BoardUpdate() {
		BoardVo vo = new BoardVo(4, null, "junit 답글작성테스트(수정)", "답글내용입니다.(수정)", 0, 0, 0, 0, null, null);
		int cnt = dao.BoardUpdate(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
//	public void DyBoardUpdateDelflag() {
//		BoardVo vo = new BoardVo(2, null, null, null, 0, 0, 0, 0, null, null);
//		int cnt = dao.DyBoardUpdateDelflag(vo);
//		System.out.println("cnt의 값은:"+cnt);
//	}
	
//	@Test
	public void BoardUpdateDelflag() {
		BoardVo vo = new BoardVo(2, null, null, null, 0, 0, 0, 0, null, null);
		int cnt = dao.BoardUpdateDelflag(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void BoardDelete() {
		BoardVo vo = new BoardVo(2, null, null, null, 0, 0, 0, 0, null, null);
		int cnt = dao.BoardDelete(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void selectAllBoard() {
		List<BoardVo> lists = dao.selectAllBoard();
		System.out.println(lists);
	}
	
}
