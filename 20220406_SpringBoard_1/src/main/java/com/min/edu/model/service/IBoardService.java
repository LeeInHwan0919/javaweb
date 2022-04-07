package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardService {
	
	public List<BoardVo> userBoardList();

	public int delflagBoard(Map<String, String[]> map);

	public int writeBoard(BoardVo vo);

	public BoardVo getOneBoard(String seq);
	
	public int replyInsert(BoardVo vo, String seq);

}
