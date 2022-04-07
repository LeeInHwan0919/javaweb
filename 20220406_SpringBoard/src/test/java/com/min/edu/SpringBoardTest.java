package com.min.edu;

import static org.junit.Assert.assertNotNull;

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
import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SpringBoardTest {

//	@Autowired
//	private ApplicationContext context;
//	
//	@Test
//	public void test() {
//		SqlSessionTemplate sqlSession = context.getBean("sqlSessionTemplate",SqlSessionTemplate.class);
//		assertNotNull(sqlSession);
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
	public void delflagBoard() {
	  Map<String, String[]> map = new HashMap<String, String[]>();
	  String[] seq= {"4,5,6,7"};
	  map.put("seqs", seq);
      int cnt = sqlSession.update("com.min.edu.model.mapper.BoardDaoImpl.delflagBoard",map);
      System.out.println(cnt+"cnt값");
	}
	
//	@Test
	public void writeBoard() {
		BoardVo vo = new BoardVo(4, "ldkkoj111", "junittest", "Test");
		 int cnt = sqlSession.update("com.min.edu.model.mapper.BoardDaoImpl.writeBoard",vo);
		 System.out.println(cnt+"cnt값");
	}
	
	@Test
	public void getOneBoard() {
		BoardVo bVo = bDao.getOneBoard("4");
		System.out.println(bVo);
	}
	
//	@Test
	public void getLogin() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id","ldkkoj111");
		map.put("pw","123456");
		UserVo loginVo = uDao.getLogin(map);
//		UserVo vo = sqlSession.selectOne("com.min.edu.model.mapper.UserDaoImpl.getLogin",map);
		System.out.println(loginVo);
	}
	
//	@Test
	public void isDuplicateCheck() {
		String id = "jinro";
		int cnt = uDao.isDuplicateCheck(id);
		System.out.println(cnt+"cnt의갯수");
	}
	
//	@Test
	public void signupMember() {
		UserVo vo = new UserVo();
		vo.setId("GD001");
		vo.setPassword("GD001");
		vo.setName("Gold");
		vo.setEmail("gold@gmail.com");
		int cnt = uDao.signupMember(vo);
		System.out.println(cnt+"cnt의갯수");
	}

		
	
}
