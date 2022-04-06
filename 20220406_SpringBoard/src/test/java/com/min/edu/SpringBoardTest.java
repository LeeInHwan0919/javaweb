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
	  String[] seq= {"1"};
	  map.put("seqs", seq);
      int cnt = sqlSession.update("com.min.edu.model.mapper.BoardDaoImpl.delflagBoard",map);
      System.out.println(cnt+"cnt값");
	}
	
	@Test
	public void writeBoard() {
		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] seqs= {"1","2"};
	      map.put("seqs", seqs);
	      sqlSession.update("com.min.edu.model.mapper.BoardDaoImpl.writeBoard",map);
	}
	
//	@Test
	public void getOneBoard() {
		List<BoardVo> lists = sqlSession.selectList("com.min.edu.model.mapper.BoardDaoImpl.getOneBoard","1");
		System.out.println(lists);
	}
	
//	@Test
	public void getLogin() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("id","ldkkoj111");
		map.put("pw","123456");
		UserVo vo = sqlSession.selectOne("com.min.edu.model.mapper.UserDaoImpl.getLogin",map);
		System.out.println(vo);
	}
	
//	@Test
	public void isDuplicateCheck() {
		int cnt = sqlSession.selectOne("com.min.edu.model.mapper.UserDaoImpl.isDuplicateCheck","ldkkoj1111");
		System.out.println(cnt+"cnt의갯수");
	}
	
//	@Test
	public void signupMember() {
		UserVo dto = new UserVo("123","123","123","123");
		int cnt = sqlSession.insert("com.min.edu.model.mapper.UserDaoImpl.signupMember",dto);
		assertNotNull(cnt);
		System.out.println(cnt+"cnt의갯수");
	}
	
}
