package com.min.edu.model.service;

import java.util.List;

import com.min.edu.vo.JobsVo;

public interface IJobsService {
	
	public List<JobsVo> JobsAllSelect();
	
	public int JobsInsert(JobsVo vo);
}
