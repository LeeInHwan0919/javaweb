package com.min.edu;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IJobsDao;
import com.min.edu.vo.JobsVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class JUnitTest {

	
	@Autowired
	private IJobsDao dao;

	@Test
	public void JobsAllSelect() {
		List<JobsVo> lists = dao.JobsAllSelect();
		System.out.println(lists);
	}

}
