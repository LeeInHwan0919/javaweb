package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.vo.JobsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BatisTest {

	private static final Logger logger = LoggerFactory.getLogger(BatisTest.class);
	
	private final String NS = "com.min.edu.model.mapper.JobsDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
//	@Test
	public void test() {
		System.out.println(sqlSession);
	}

	@Test
	public void selectJobAll() {
		logger.info("selectJobAll() Test");
		List<JobsVO> lists = sqlSession.selectList(NS+"selectJobAll");
		System.out.println(lists);
	}
}
