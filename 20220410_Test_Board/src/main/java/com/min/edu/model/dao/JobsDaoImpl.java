package com.min.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.JobsVo;

	@Repository
	public class JobsDaoImpl implements IJobsDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String NS = "com.min.edu.model.dao.JobsDaoImpl.";



	@Override
	public List<JobsVo> jobSelect() {
		return sqlSession.selectList(NS+"jobSelect");
	}
	
	
}


