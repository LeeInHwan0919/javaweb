package com.min.edu.mapper;

import org.apache.ibatis.jdbc.SQL;

// 쿼리를 생성하는 클래스
public class JobsProvider {
	// SQL을 생성
	
	// SQL을 생성하는 메소드
	public String getSelectAll() {
	SQL sql = new SQL(){{
		SELECT("JOB_ID");
		SELECT("JOB_TITLE");
		SELECT("MIN_SALARY");
		SELECT("MAX_SALARY");
		//SET("id=#{id}")
		FROM("JOBS");
		}};
		return sql.toString();
	}
}
