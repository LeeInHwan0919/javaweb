package com.min.edu.model.service;

import java.util.List;

import com.min.edu.vo.JobsVO;

public interface IJobsService {
	public List<JobsVO> selectJobAll();
	public int insertJob(JobsVO vo); 
}
