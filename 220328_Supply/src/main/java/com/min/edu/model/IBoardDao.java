package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.BoardVo;

public interface IBoardDao {

	public List<BoardVo> getAllBoard();
	public BoardVo getOneBoard(String seq);
}
