package com.min.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IMemberDao;
import com.min.edu.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/*.xml" })
public class MemberTest {

	@Autowired
	private IMemberDao dao;
	
	private final Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
	@Test
	public void selectMemberAllTest() {
		logger.info("MemberTest selectMemberAllTest");
//		List<MemberVo> lists =  dao.selectMemberAll();
//		System.out.println(lists);
	}
//	@Test
	public void insertMemberTest() {
		logger.info("MemberTest insertMemberTest");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "GD004");
		map.put("pw", "1234");
		int result = dao.insertMember(map);
		System.out.println(result);
		
	}
//	@Test
	public void loginMemberTest() {
		logger.info("MemberTest loginMemberTest");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "GD002");
		map.put("pw", "1234");
		MemberVo vo = dao.loginMember(map);
		System.out.println(vo);
	}
//	@Test
//	public void passwordCheckTest() {
//		logger.info("MemberTest passwordCheckTest");
//		String pw = "1234"
//		dao.passwordCheck(pw);
//	}
//	@Test
//	public void Test() {
//		logger.info("MemberTest ");
//	}
	
	@Test
	public void idCheck() {
		logger.info("MemberTest idCheck");
		int cnt = dao.idCheck("GD004");
		System.out.println(cnt);
	}


}
