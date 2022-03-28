package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.CalendarDto;

public interface ICalBoardDao {
  //각 달력 일별 리스트
	public List<CalendarDto> getCalViewList(Map<String,Object> map);
	
  // 일정 추가
	public boolean insertCalBoard(CalendarDto dto);
	
  //일정 게시글 조회
	public List<CalendarDto> getCalList(Map<String,Object> map);
	
  // 일정 갯수
	public int getCalCount(Map<String,Object> map);
	
	//일정상세
	public CalendarDto getCalDetail(Map<String,Object> map);
	
	//일정삭제
	public boolean multiDel(String[] seqs);
}
