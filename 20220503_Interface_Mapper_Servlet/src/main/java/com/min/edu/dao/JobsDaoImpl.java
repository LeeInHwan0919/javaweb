package com.min.edu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.JobsDto;
import com.min.edu.mybatis.MybatisSqlSession;
import com.min.edu.sqls.SqlJobsInterface_Mapper;

public class JobsDaoImpl implements IJobsDao {

	private SqlSessionFactory manager = MybatisSqlSession.getFactory();
	
	@Override
	public List<JobsDto> selectAll() {
		List<JobsDto> lists = null;
		SqlSession session = manager.openSession();
		// SqlSessionFactory에 많은 Mapper Interface가 연결되어 있음
		// xml 의 방식이라면... namespace를 통해서 구분
		// interface의 방식이라면... 클래스를 명시해준다
		SqlJobsInterface_Mapper mapperInterface = session.getMapper(SqlJobsInterface_Mapper.class);
		
		// 쿼리 실행
		lists = mapperInterface.selectAll();
		
		return lists;
	}

	@Override
	public JobsDto selectOne(String job_id) {
		return null;
	}

}
