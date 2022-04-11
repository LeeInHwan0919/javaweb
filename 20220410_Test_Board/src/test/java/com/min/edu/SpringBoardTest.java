package com.min.edu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/application-context.xml")
public class SpringBoardTest {

@Autowired
private ApplicationContext context;

@Before
public void before() {
	System.out.println("테스트 시작");
}
@After
public void after() {
	System.out.println("테스트 종료");
}

@Test
public void dbConnectTest() {
	SqlSessionTemplate session = context.getBean("sqlSessionTemplate",SqlSessionTemplate.class);
	System.out.println(session.toString());
}
}
