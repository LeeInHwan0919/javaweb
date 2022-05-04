package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.RowNumVo;

public interface IBoardService {
	
	public int insertBoard(Map<String, Object> map);
	
	public int reply(String seq, Map<String, Object> map);
	
	public BoardVo selectDetail(String chk);
	
	public int BoardUpdate(Map<String, Object> map);
	
	public int Delete(String seq);
	
	public List<BoardVo> selectAllBoard();
	
	public List<BoardVo> selectDown(Map<String, Object> map);
	
	
	public int MultipleDelete(Map<String, String[]> map);
	
	/*
	 * 페이징 처리
	 */
	public List<BoardVo> adminBoardListRow(RowNumVo vo);
	public int adminBoardListTotal();
	public List<BoardVo> userBoardListRow(RowNumVo vo);
	public int userBoardListTotal();
}
