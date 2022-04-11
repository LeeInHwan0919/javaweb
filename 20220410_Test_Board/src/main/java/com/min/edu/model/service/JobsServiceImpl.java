package com.min.edu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.dao.IJobsDao;
import com.min.edu.vo.JobsVo;

@Service
public class JobsServiceImpl implements IJobsService {

@Autowired
private IJobsDao dao;

@Override
public List<JobsVo> jobSelect() {
return dao.jobSelect();
}

}
