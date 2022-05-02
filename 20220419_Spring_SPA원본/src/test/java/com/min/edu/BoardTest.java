package com.min.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/*.xml" })
public class BoardTest {

	
	@Autowired
	private IBoardDao dao;
	
	@Autowired
	SqlSessionTemplate sqlsession;
	
	private final Logger logger = LoggerFactory.getLogger(BoardTest.class);
	
//	@Test
	public void insertBoardRootTest() {
		logger.info("IBoardDao insertBoardRootTest ");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "GD004");
		map.put("title", "JUnit Test");
		map.put("content", "JUnit Test 글 본문입니다");
		int result = dao.insertBoardRoot(map);
		System.out.println(result);
	}
//	@Test
	public void insertBoardAnswerTest() {
		logger.info("IBoardDao insertBoardAnswerTest ");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "GD004");
		map.put("title", "JUnit Test Answer");
		map.put("content", "JUnit Test 답글 본문입니다");
		map.put("seq", 8);
		int result = dao.insertBoardAnswer(map);
		System.out.println(result);
	}
	
//	@Test
	public void updateBoardAnswerTest() {
		logger.info("IBoardDao updateBoardAnswerTest");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", 8);
		int cnt = dao.updateBoardAnswer(map);
		System.out.println(cnt);
	}
	
//	@Test
	public void selectBoardDetailTest() {
		logger.info("IBoardDao selectBoardDetailTest ");
		String seq = "4";

		BoardVo vo =  dao.selectBoardDetail(seq);
		System.out.println(vo);
	}
//	@Test
	public void updateReadcountTest() {
		logger.info("IBoardDao updateReadcountTest ");
		String seq = "4";
		int result = dao.updateReadcount(seq);
		System.out.println(result);
	}
//	@Test
	public void updateBoardDetailTest() {
		logger.info("IBoardDao updateBoardDetailTest ");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "JUnit Test 수정");
		map.put("content", "JUnit Test 로 수정된 본문입니다");
		map.put("seq", 4);
		int result = dao.updateBoardDetail(map);
		System.out.println(result);
	}
//	@Test
	public void updateBoardDelflagTest() {
//		logger.info("IBoardDao updateBoardDelflagTest ");
//		String[] seqs = {"3","5"};
//		int result = dao.updateBoardDelflag(seqs);
//		System.out.println(result);
		
	}
//	@Test
	public void deleteBoardTest() {
//		logger.info("IBoardDao deleteBoardTest ");
//		String seq = "5";
//		int result = dao.deleteBoard(seq);
//		System.out.println(result);
	}
	//@Test
	public void selectBoardAllAdminTest() {
		logger.info("IBoardDao  selectBoardAllAdminTest");
		List<BoardVo> lists = dao.selectBoardAllAdmin();
		System.out.println(lists);
	}
//	@Test
	public void selectBoardAllUserTest() {
		logger.info("IBoardDao selectBoardAllUserTest");
		List<BoardVo> lists = dao.selectBoardAllUser();
		System.out.println(lists);
	}
	
	//@Test
	public void userBoardListRow() {
		logger.info("IBoardDao userBoardListRow");
		RowNumVo vo = new RowNumVo();
		List<BoardVo> lists = sqlsession.selectList("com.min.edu.model.mapper.BoardDaoImpl.userBoardListRow",vo);
		System.out.println(lists);
	}
	
	@Test
	public void selectBoardAllTest() {
		MemberVo mVo = new MemberVo();
		mVo.setAuth("A");
		List<BoardVo> vo = dao.selectBoardAll(mVo);
		System.out.println(vo);
	}
	

}
