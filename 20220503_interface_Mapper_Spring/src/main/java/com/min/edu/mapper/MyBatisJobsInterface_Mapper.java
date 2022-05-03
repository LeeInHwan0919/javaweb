package com.min.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.min.edu.dto.JobsDto;

public interface MyBatisJobsInterface_Mapper {

//	@Select("SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS")
	// type 쿼리 제공 클래스 , method는 쿼리를 반환하는 메ㅗ드명
	@SelectProvider(type = JobsProvider.class,method = "getSelectAll")
	public List<JobsDto> selectAll();
	
}
