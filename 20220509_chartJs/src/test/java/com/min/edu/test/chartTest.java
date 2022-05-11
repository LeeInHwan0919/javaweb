package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.IGoodsService;
import com.min.edu.vo.GraphVo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class chartTest {

//	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IGoodsService service;

//	@Test
	public void tamplateTest() {
		assertNotNull(sqlSession);
	}
	
	@Test
	public void test() {
		List<GraphVo> lists = service.countGoods();
		System.out.println(lists);
	}
	
	
}
