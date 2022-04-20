package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardService {
	
	public int insertBoard(BoardVo vo);
	
	public int reply(BoardVo vo);
	
	public BoardVo DetailBoard(BoardVo vo);
	
	public int BoardUpdate(BoardVo vo);
	
	public int BoardUpdateDelflag(BoardVo vo);
	
	public int BoardDelete(BoardVo vo);
	
	public List<BoardVo> selectAllBoard();
	
	public List<BoardVo> selectDown(BoardVo vo);
	
	public int delfalgUpdate(Map<String, String[]> map);
	
	public int MultipleDelete(Map<String, String[]> map);
	
	public List<BoardVo> boardPaging(int page);
	
	public int rowCount();
}
