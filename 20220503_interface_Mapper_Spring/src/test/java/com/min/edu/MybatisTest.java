package com.min.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.dto.JobsDto;
import com.min.edu.mapper.MyBatisJobsInterface_Mapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class MybatisTest {

	@Autowired
	private MyBatisJobsInterface_Mapper mapper;
	
	@Test
	public void test() {
		List<JobsDto> lists = mapper.selectAll();
		System.out.println(lists);
		assertNotNull(lists);
	}

}
