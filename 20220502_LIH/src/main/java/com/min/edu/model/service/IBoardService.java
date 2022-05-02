package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardService {
	
	public int insertBoard(Map<String, Object> map);
	
	public int reply(Map<String, Object> map);
	
	public BoardVo DetailBoard(Map<String, Object> map);
	
	public int BoardUpdate(Map<String, Object> map);
	
	
	public int BoardDelete(Map<String, Object> map);
	
	public List<BoardVo> selectAllBoard();
	
	public List<BoardVo> selectDown(Map<String, Object> map);
	
	
	public int MultipleDelete(Map<String, String[]> map);
	
	public List<BoardVo> boardPaging(int page);
	
	public int rowCount();
}
