package com.min.edu.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.vo.JobsVo;

@Repository
public class JobsDaoImpl implements IJobsDao {

	private final String NS = "com.min.edu.model.mapper.JobsDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<JobsVo> JobsAllSelect() {
		return sqlSession.selectList(NS+"JobsAllSelect");
	}

	
	@Override
	public int JobsInsert(JobsVo vo) {
		int cnt = sqlSession.insert(NS+"JobsInsert",vo);
		return cnt;
	}


	@Override
	public int JobsUpdate() {
		int cnt = sqlSession.insert(NS+"JobsUpdate");
		return cnt;
	}
	
	

	
}
