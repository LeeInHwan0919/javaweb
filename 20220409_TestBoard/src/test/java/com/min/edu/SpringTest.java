package com.min.edu;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SpringTest {

	@Autowired
	private ApplicationContext context;
	
	@Test
	public void test() {
		SqlSessionTemplate sqlSession = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
		assertNotNull(sqlSession);
	}

}
