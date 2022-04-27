package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

public interface IBoardDao {

	public int insertBoardRoot(Map<String, Object> map);
	public int insertBoardAnswer(Map<String, Object> map);
	public int updateBoardAnswer(Map<String, Object> map);
	public BoardVo selectBoardDetail(String seq);
	public int updateReadcount(String seq);
	public int updateBoardDetail(Map<String, Object> map);
	
	public int updateBoardDelflag(Map<String, String[]> seqs);
	public int deleteBoard(List<String> seqs);
	
	public List<BoardVo> selectBoardAll(MemberVo mVo);
	public List<BoardVo> selectBoardAllAdmin();
	public List<BoardVo> selectBoardAllUser();
	
	public List<BoardVo> deleteBoardSel(String seq);
	
	/*
	 * 페이징 처리
	 */
	public List<BoardVo> adminBoardListRow(RowNumVo vo);
	public int adminBoardListTotal();
	public List<BoardVo> userBoardListRow(RowNumVo vo);
	public int userBoardListTotal();
	
	
	
	
	
}
