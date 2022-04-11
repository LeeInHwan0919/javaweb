package com.min.edu;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SpringBoardTest {

//	@Autowired
//	private ApplicationContext context;
//	
//	public void test() {
//		SqlSessionTemplate session = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
//		assertNotNull(session);
//	}
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IUserDao uDao;
	
	@Autowired
	private IBoardDao bDao;
	
//	@Test
	public void templateTest() {
		assertNotNull(sqlSession);
	}
	
//	@Test
	public void userBoardList() {
		List<BoardVo> lists = sqlSession.selectList("com.min.edu.model.mapper.BoardDaoImpl.userBoardList");
		System.out.println(lists);
	}
//	@Test
	public void deflagBoard() {
		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] seq = {"1","2","3","4"};
		map.put("seqs", seq);
		sqlSession.update("com.min.edu.model.mapper.BoardDaoImpl.userBoardList.deflagBoard", map);
	}
	
//	@Test
	public void getLogin() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "jinro");
		map.put("pw", "1234");
		UserVo loginVo = uDao.getLogin(map);
		System.out.println(loginVo);
	}
	
//	@Test
	public void isDuplicateCheck () {
		String id ="jinro2";
		int n = uDao.isDuplicateCheck(id);
		System.out.println(n);
	}
	
//	@Test
	public void singupMember() {
		UserVo vo = new UserVo();
		vo.setId("GD001");
		vo.setPassword("GD001");
		vo.setName("Gold");
		vo.setEmail("gold@gmail.com");
		int n = uDao.singupMember(vo);
		System.out.println(n);
	}
	
	
//	@Test
	public void getOneBoard() {
		BoardVo bVo =  bDao.getOneBoard("18");
		System.out.println(bVo);
	}

//	@Test
	public void userSelectAll() {
		List<UserVo> lists=sqlSession.selectList("com.min.edu.model.mapper.UserDaoImpl.userSelectAll");
		System.out.println(lists);
	}
	
//	@Test
	public void userSelectOne() {
		String id="jinro";
		UserVo vo=sqlSession.selectOne("com.min.edu.model.mapper.UserDaoImpl.userSelectOne", id);
		System.out.println(vo);
	}
	
//	@Test
	public void getSearchUser() {
		UserVo vo = new UserVo();
		vo.setOpt("name");
		vo.setKeyword("참이슬");
		List<UserVo>lists=sqlSession.selectList("com.min.edu.model.mapper.UserDaoImpl.getSearchUser", vo);
		System.out.println(lists);
	}
	
//	@Test
	public void replyUpdate() {
		String seq = "13";
		int n = bDao.replyUpdate(seq);
		System.out.println(n+"n의값");
	}
	
//	@Test
	public void replyInsert() {
		BoardVo vo = new BoardVo(13, "id", "title", "content", 0, 0, 0, null, null);
		int n = bDao.replyInsert(vo);
		System.out.println(n+"n의값");
	}
//	@Test
	public void restoreBoard() {
		List<BoardVo> lists = sqlSession.selectList("com.min.edu.model.mapper.BoardDaoImpl.restoreBoard");
		System.out.println(lists);
	}
//	@Test
	public void restoreDelflag() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", "13");
		int cnt = sqlSession.update("com.min.edu.model.mapper.BoardDaoImpl.restoreDelflag", map);
		System.out.println(cnt);
	}
	@Test
	public void findId() {
		Map<String, Object> map = new HashMap<String, Object>()	;
		map.put("name", "Gold");
		map.put("email", "gold@gmail.com");
		String id =  uDao.findId(map);
		System.out.println(id);
	}
}







