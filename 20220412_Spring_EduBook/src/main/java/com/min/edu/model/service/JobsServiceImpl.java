package com.min.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.model.mapper.IJobsDao;
import com.min.edu.model.mapper.JobsDaoImpl;
import com.min.edu.vo.JobsVO;

@Service
public class JobsServiceImpl implements IJobsService{

	private static final Logger logger = LoggerFactory.getLogger(JobsDaoImpl.class); 
	@Autowired
	private IJobsDao dao;
	
	@Transactional
	@Override
	public List<JobsVO> selectJobAll() {
		logger.info("service selectJobAll() 실행");
		return dao.selectJobAll();
	}

	@Transactional
	@Override
	public int insertJob(JobsVO vo) {
		logger.info("service insertJob() 실행");
		return dao.insertJob(vo);
	}

}
