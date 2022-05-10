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

import com.min.edu.model.ITurtleService;
import com.min.edu.vo.GraphVo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class chartTest {

//	@Autowired
//	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ITurtleService service;

//	@Test
//	public void tamplateTest() {
//		assertNotNull(sqlSession);
//	}
	
	@Test
	public void test() {
		List<GraphVo> lists = service.countTurtle();
		System.out.println(lists);
	}
	
	
}
