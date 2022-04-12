package com.min.edu.model.mapper;

import java.util.List;

import com.min.edu.vo.JobsVO;

public interface IJobsDao {
	public List<JobsVO> selectJobAll();
	public int insertJob(JobsVO vo);
}
