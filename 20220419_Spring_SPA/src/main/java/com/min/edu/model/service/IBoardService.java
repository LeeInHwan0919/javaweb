package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

public interface IBoardService {
	/*새글쓰기*/
	public int insertBoardRoot(Map<String, Object> map);
	/*답글 Transaction 처맄*/
	public int boardAnswer(Map<String, Object> map);
	/*상세글보기*/
	public BoardVo selectBoardDetail(String seq);
	/*글 수정*/
	public int updateBoardDetail(Map<String, Object> map);
	
	/*글 삭제*/
	public int updateBoardDelflag(Map<String, String[]> seqs);
	/*글 삭제*/
	public int deleteBoard(List<String> seqs);
	
	/*게시글 전체보기 DYNAMIC QUERY*/
	public List<BoardVo> selectBoardAll(MemberVo mVo);
	
	/*관리자 게시글 전체보기*/
	public List<BoardVo> selectBoardAllAdmin();
	/*사용자 게시글 전체보기*/
	public List<BoardVo> selectBoardAllUser();
	
	
	/*하위 삭제 대상 deleteBoardSel*/
	public List<BoardVo> deleteBoardSel(String seq);
	
	/*
	 * 페이징 처리
	 */
	/*관리자 게시글 페이징*/
	public List<BoardVo> adminBoardListRow(RowNumVo vo);
	/*관리자 전체글 갯수*/
	public int adminBoardListTotal();
	/*사용자 게시글 페이징*/
	public List<BoardVo> userBoardListRow(RowNumVo vo);
	/*사용자 전체글 갯수*/
	public int userBoardListTotal();



		


		
}
