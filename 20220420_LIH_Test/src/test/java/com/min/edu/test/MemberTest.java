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
import org.springframework.test.context.web.WebAppConfiguration;

import com.min.edu.model.mapper.IMemberDao;
import com.min.edu.vo.MemberVo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MemberTest {

	private final String NS = "com.min.edu.model.mapper.MemberDaoImpl.";

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
		MemberVo vo = new MemberVo("화이팅","1234","U", null, null);
		int cnt = dao.signUp(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void login() {
		MemberVo vo = new MemberVo("USER","1234",null, null, null);
		int cnt = dao.login(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
	@Test
	public void confirmPw() {
		String pw = dao.confirmPw("화이팅");
		System.out.println("password의 값은 :"+pw);
	}
	
	
}
