package com.min.edu.model.mapper;

import java.util.List;

import com.min.edu.vo.JobsVo;


public interface IJobsDao {
	
	public List<JobsVo> JobsAllSelect();
	
	public int JobsInsert(JobsVo vo);
	
	public int JobsUpdate();
}
