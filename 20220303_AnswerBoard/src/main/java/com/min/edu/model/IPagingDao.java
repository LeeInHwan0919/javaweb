package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.AnswerBoardDto;

public interface IPagingDao {
	
	/*
	 * 페이지에 따른 10개씩 가져오는 select문
	 */
	public List<AnswerBoardDto> boardPaging(int page);
	
	/*
	 * 전체 게시글의 갯수
	 */
	public Integer rowCount();
	
}
