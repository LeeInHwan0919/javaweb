package com.min.edu.sqls;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.min.edu.dto.JobsDto;

public interface SqlJobsInterface_Mapper {

  // 전체 조회
	@Select("SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS")
	public List<JobsDto> selectAll();
	
  // 상세 조회
	@Select("SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS WHERE JOB_ID = #{job_id}")
	public JobsDto selectOne(String job_id);
	
}
