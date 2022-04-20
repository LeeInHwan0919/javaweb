package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardService {
	/*새글쓰기*/
	public int insertBoardRoot(Map<String, Object> map);
	
	/*답글 Transaction 처리*/
	public int boardAnswer(Map<String, Object> map);
	
	/*상세글보기*/
	public BoardVo selectBoardDetail(String seq);
	/*글수정*/
	public int updateBoardDetail(Map<String, Object> map);
	
	/*글삭제*/
	public int updateBoardDelflag(Map<String, String[]> seqs);
	/*글삭제*/
	public int deleteBoard(List<String> seqs);
	
	/*관리자 게시글 전체 보기*/
	public List<BoardVo> selectBoardAllAdmin();
	/*사용자 게시글 전체 보기*/
	public List<BoardVo> selectBoardAllUser();
	
	/*하위 삭제 대상 deleteBoardSel*/
	public List<BoardVo> deleteBoardSel(String seq); 
	
	/*관리자 게시글 페이징*/
	/*관리자 전체글 갯수*/
	/*사용자 게시글 페이징*/
	/*사용자 전체글 갯수*/
}
