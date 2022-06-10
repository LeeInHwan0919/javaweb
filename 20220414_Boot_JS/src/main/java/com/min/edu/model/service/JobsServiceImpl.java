package com.min.edu.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.dao.IJobsDao;

@Service
public class JobsServiceImpl implements IJobsService {

	
	@Autowired
	IJobsDao dao;

	@Override
	public String selectTest() {
		return dao.selectTest();
	}

}
