package com.min.edu.dao;

import java.util.List;

import com.min.edu.dto.JobsDto;

public interface IJobsDao {

	public List<JobsDto> selectAll();
	public JobsDto selectOne(String job_id);
}
