package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardDao {

	public int insertBoard(BoardVo vo);
	
	public int replyUpdate(BoardVo vo);
	
	public int replyInsert(BoardVo vo);
	
	public BoardVo selectDetail(BoardVo vo);
	
	public int ReadCount(BoardVo vo);
	
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
