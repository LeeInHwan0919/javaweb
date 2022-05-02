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

import com.min.edu.model.mapper.IMemberDao;
import com.min.edu.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MemberTest {


	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private IMemberDao dao;

//	@Test
	public void tamplateTest() {
		assertNotNull(sqlSession);
	}

//	@Test
	public void selectAllMember() {
		List<MemberVo> lists =  dao.selectAllMember();
		System.out.println(lists);
	}
	
//	@Test
	public void signUp() {
//		MemberVo vo = new MemberVo("Member","1234","U", null, null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "Member");
		map.put("pw", "1234");
		map.put("name","홍길동1");
		map.put("email","abcd@naver.com");
		int cnt = dao.signUp(map);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void login() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "Member");
		map.put("pw", "1234");
		int cnt = dao.login(map);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void confirmPw() {
		String pw = dao.confirmPw("Member");
		System.out.println("password의 값은 :"+pw);
	}
	
	//아이디 찾기
//	@Test
	public void findID() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "테스트");
		map.put("email", "test@naver.com");
		String id = dao.findID(map);
		System.out.println("아이디 값은 : "+id);
	}
	
}
