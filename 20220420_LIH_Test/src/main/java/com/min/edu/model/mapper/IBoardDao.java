package com.min.edu.model.mapper;

import java.util.List;

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
	
	
}
