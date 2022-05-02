package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardDao {

	public int insertBoard(Map<String, Object> map);
	
	public int replyUpdate(Map<String, Object> map);
	
	public int replyInsert(Map<String, Object> map);
	
	public BoardVo selectDetail(Map<String, Object> map);
	
	public int ReadCount(Map<String, Object> map);
	
	public int BoardUpdate(Map<String, Object> map);
	
	
	public int BoardDelete(Map<String, Object> map);
	
	public List<BoardVo> selectAllBoard();
	
	public List<BoardVo> selectDown(Map<String, Object> map);
	
	
	public int MultipleDelete(Map<String, String[]> map);
	
	public List<BoardVo> boardPaging(int page);
	
	public int rowCount();
}
