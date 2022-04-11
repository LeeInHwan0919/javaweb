package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardDao {
	
	public List<BoardVo> userBoardList();

	public int deflagBoard(Map<String, String[]> map);

	public int writeBoard(BoardVo vo);

	public BoardVo getOneBoard(String seq);

	public int replyUpdate(String seq);
	
	public int replyInsert(BoardVo vo);
	
	public List<BoardVo> restoreBoard();
	
	public int restoreDelflag(String seq);
}
