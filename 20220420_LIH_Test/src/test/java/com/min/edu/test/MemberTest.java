package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.List;

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
		MemberVo vo = new MemberVo("Member","1234","U", null, null);
		int cnt = dao.signUp(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void login() {
		MemberVo vo = new MemberVo("Member","1234",null, null, null);
		int cnt = dao.login(vo);
		System.out.println("cnt의 값은:"+cnt);
	}
	
//	@Test
	public void confirmPw() {
		String pw = dao.confirmPw("Member");
		System.out.println("password의 값은 :"+pw);
	}
	
	
}
