package com.min.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.model.mapper.IJobsDao;
import com.min.edu.vo.JobsVo;

@Transactional
@Service
public class JobsServiceImpl implements IJobsService {

	private static final Logger logger = LoggerFactory.getLogger(JobsServiceImpl.class);
	
	@Autowired
	private IJobsDao dao;
	
	@Override
	public List<JobsVo> JobsAllSelect() {
		logger.info("JobsServiceImpl JOBS전체조회 JobsAllSelect");
		return dao.JobsAllSelect();
	}
	
	@Override
	public int JobsInsert(JobsVo vo) {
		logger.info("JobsInsert");
		int n = dao.JobsUpdate();
		int m = dao.JobsInsert(vo);
		return (n>0||m>0)?1:0; 
	}


}
