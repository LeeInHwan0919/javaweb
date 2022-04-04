 package com.min.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.vo.EduVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/application-context.xml")
public class Test {

	@Autowired
	private ApplicationContext context;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Before
	public void before() {
		System.out.println("spring Junit Test 시작 (before)");
	}
	
	@After
	public void after() {
		System.out.println("Spring Junit Test 종료(After)");
	}
	
//	@org.junit.Test
	public void dbDonnecTest() {
	  SqlSessionTemplate session = context.getBean("SqlSessionTemplate",SqlSessionTemplate.class);
	  System.out.println(session.toString());
	}
	
	@org.junit.Test
	public void selectBoardTest() {
		List<EduVo> lists =  sqlSession.selectList("com.min.edu.model.EduDaoImpl.selectBoard");
		System.out.println(lists);
		assertNotNull(lists);
	}
		
}
