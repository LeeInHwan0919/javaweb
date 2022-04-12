package com.min.edu.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.JobsVO;

@Repository
public class JobsDaoImpl implements IJobsDao {
	
	private Logger logger = LoggerFactory.getLogger(JobsDaoImpl.class); 
	private final String NS = "com.min.edu.model.mapper.JobsDaoImpl.";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<JobsVO> selectJobAll() {
		return sqlSession.selectList(NS+"selectJobAll");
	}

	@Override
	public int insertJob(JobsVO vo) {
		return sqlSession.insert(NS+"insertJob",vo);
	}

}
