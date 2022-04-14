package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BatisTest {

	private final String NS = "com.min.edu.model.mapper.UserDaoImpl.";

	@Autowired
	private SqlSessionTemplate sqlSession;

//	@Test
	public void tamplateTest() {
		assertNotNull(sqlSession);
	}

//	@Test
	public void login() {
//		UserVo vo = new UserVo();
//		vo.setId("GD001");
//		vo.setPassword("GD001");
//		UserVo uVo = sqlSession.selectOne(NS + "login", vo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "GD001");
		map.put("password", "GD001");
		UserVo uVo = sqlSession.selectOne(NS+"login",map);
		System.out.println("쿼리의결과:" + uVo);
	}
	
	@Test
	public void resultValueTest() {
		Object o = sqlSession.selectOne(NS+"resultValue");
		System.out.println("쿼리의결과"+o);
	}
	
	
}
